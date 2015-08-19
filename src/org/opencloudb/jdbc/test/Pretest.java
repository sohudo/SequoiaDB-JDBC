package  org.opencloudb.jdbc.test;

import java.sql.*;

public class Pretest {

		    public static void main( String args[] )
		        throws SQLException , ClassNotFoundException {
		    	int dbtype=7;
		    	String jdbcdriver="";
		    	String jdbcurl="";
	    	    String username="jifeng";
	    	    String password="jifeng";		    	
		    	switch (dbtype) {
		    	case 1:jdbcdriver="org.apache.hive.jdbc.HiveDriver";
		    	       jdbcurl="jdbc:hive2://feng01:10000";//"jdbc:hive2://feng01:10000";
		    	       username="jifeng";
		    	       password="jifeng";
		    	       break;
		    	case 2:jdbcdriver="org.postgresql.Driver";
		    	       jdbcurl="jdbc:postgresql://127.0.0.1:5432/ecp";
		    	       username="postgres";
		    	       password="jifeng";
		    	       break;
		    	case 3:jdbcdriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		    	jdbcurl="jdbc:sqlserver://127.0.0.1:49201; DatabaseName=test";//jdbcurl="jdbc:sqlserver://localhost:7788; DatabaseName=ldw";
		    	       username="sa";
		    	       password="sa";
		    	       break;
		    	case 4:jdbcdriver="oracle.jdbc.OracleDriver";
		    	       jdbcurl="jdbc:oracle:thin:@192.168.0.95:1521:orcl";
		    	       username="ms";
		    	       password="Kingmed123";		    	       
		    	       break;
		    	case 5:jdbcdriver="org.opencloudb.jdbc.mongodb.MongoDriver";
		    	       jdbcurl="mongodb://192.168.0.99/test";
		    		   break;
		    	case 7:jdbcdriver="org.opencloudb.jdbc.sequoiadb.SequoiaDriver";
	    	       jdbcurl="sequoiadb://1426587161.dbaas.sequoialab.net:11920/SAMPLE";
	    		   break;		    		   
		    	case 6:jdbcdriver="com.mysql.jdbc.Driver";
		    	       jdbcurl="jdbc:mysql://localhost:8066/TESTDB";
		    	       username="test";
		    	       password="test";		    	       
		    	       break;
		    	}
	    	     

	    	    Class.forName(jdbcdriver);
	    	    Connection c = DriverManager.getConnection(jdbcurl,username,password); 
		        Statement st = c.createStatement();
                
		       // st.executeUpdate("insert into sqlCL (a,b,c) values(4,'周',22)");
		      //  st.executeUpdate("update sqlCL set c=19 where b='xx'");
		       // st.executeUpdate("delete from sqlCL where b='xx'");
		       // sql = "insert into " + csFullName + " (a,b,c)" + " values(2,\"xx\",21)";
		        
		       //st.executeUpdate("create table people (name varchar(30),age int,sex int,diqu varchar(20),lev int)");
		        //st.executeUpdate("insert into people (name,age,sex,diqu,lev) values('xx',20,1,'gz',2)");
		      //  st.execute("delete from people  where name='xx'");
		      // st.execute(" drop table people");
		       print( "测试 " , st.executeQuery("select * from people "));                
		        //( "select id,name,vip from users order by id limit 5" ) );
		       
		        // TODO indexing
		    }
			 static void print( String name , ResultSet res )
				        throws SQLException {
				        System.out.println( name);
				        ResultSetMetaData meta=res.getMetaData();				        
		                //System.out.println( "\t"+res.getRow()+"条记录");
		                String	str="";
		                for(int i=1;i<=meta.getColumnCount();i++){
		                	str+=meta.getColumnName(i)+"   ";
		                	//System.out.println( meta.getColumnName(i)+"   ");
		                }
		                System.out.println("\t"+str);
		                str="";
				        while ( res.next() ){
				        	for(int i=1;i<=meta.getColumnCount();i++){	
				        		str+= res.getString(i)+"   ";				        	} 
				        	System.out.println("\t"+str);
				        	str="";
				        }
				    }	    
}
