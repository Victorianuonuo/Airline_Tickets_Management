
public class SQL {
	
	   String s;
	
	   public void select(String col, String table, String cond)  {
			s="select " + col + " "
				+ "from " + table + " "
				+ "where ( " + cond + " ); ";
		}
	   
	   public void select(String col, String table, String cond,String order)  {
			s="select " + col + " "
				+ "from " + table + " "
				+ "where ( " + cond + " ) "
				+" order by ( "+order+" ) ; ";
		}
		
	    public void insert(String table, String tuple)  {
			s="insert into "+ table + " "
				+ tuple + " ; ";
		}

	    public void update(String table, String set, String cond) {
			s="update "+ table + " "
				+ "set " + set + " "
				+ "where ( " + cond + " );";
		}
		
	    public void delete(String table, String cond){
			s="delete from "+ table + " "
				+ "where ( " + cond + " );";
		}
	   
       @Override
        public String toString() {
    	// TODO Auto-generated method stub
    	return s;
        }
    
       
}
