package com.onlineShopping;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product extends Show {
	PreparedStatement ps = null;
	Connection connection = null;

	public void insertProduct() {
		try {
			ConnectionTest test = new ConnectionTest();
			connection = test.getConnectionDetail();
			ps = connection.prepareStatement(
					"insert into product(product_id,name,price,decription,quantity)values(?,?,?,?,?)");
//---------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1001);
			ps.setString(2, "Apple iphone 11");
			ps.setInt(3, 41963);
			ps.setString(4,"\n"
					
					+ "• Display     :- 15.49 cm  Liquid Retina HD Display\r\n"
					+ "• Front Camera:- 12MP\r\n"
					+ "• Rare Camera :- 12MP + 12MP\r\n"
					+ "• RAM         :-8GB\r\n"
					+ "• Stroage     :- 128 GB ROM\r\n"
					+ "");
			ps.setInt(5, 100);
		
			
//----------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1002);
			ps.setString(2, "Samsung Galaxy S22 Ultra");
			ps.setInt(3, 90400);
			ps.setString(4,"\n"
					+ "• Display     :- 17.27 cm Display\r\n"
					+ "• Front Camera:- 12MP\r\n"
					+ "• Rare Camera :- 108MP Rear Camera\r\n"
					+ "• RAM         :- 12 GB \r\n"
					+ "• Stroage     :-  256 GB ROM\r\n"
					+ "");
					
			ps.setInt(5, 100);
			
		
//----------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1003);
			ps.setString(2, "vivo X80 Pro Plus 5G");
			ps.setInt(3, 82990);
			ps.setString(4,"\n"
					+ "• Display     :- 16.89 cm Display\r\n"
					+ "• Front Camera:- 32MP \r\n"
					+ "• Rare Camera :- 50MP + 48MP + 12MP + 8MP Rear Camera\r\n"
					+ "• RAM         :- 12 GB RAM\r\n"
					+ "• Stroage     :-  128 GB ROM\r\n"
					+ "");
					
			ps.setInt(5, 100);
		
			
//-----------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1004);
			ps.setString(2, "Samsung Galaxy Z Fold 4 5G");
			ps.setInt(3, 134899);
			ps.setString(4,"\n"
					+ "• Display :- 15.98 cm  Display\r\n"
					+ "• Front Camera:- 32MP \r\n"
					+ "• Rare Camera :-   64MP  Rear Camera\r\n"
					+ "• RAM :- 8GB RAM\r\n"
					+ "• Stroage :-  256 GB ROM\r\n"
					+ "");
					
			ps.setInt(5, 100);
//--------------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1005);
			ps.setString(2, "Xiaomi 12 Pro 5G");
			ps.setInt(3, 54999);
			ps.setString(4,"\n"
					+ "• Display :- 16.56 cm Display\r\n"
					+ "• Front Camera:- 48MP \r\n"
					+ "• Rare Camera :- 128MP Rear Camera\r\n"
					+ "• RAM :- 6GB RAM\r\n"
					+ "• Stroage :-  128 GB ROM\r\n"
					+ "");
					
			ps.setInt(5, 100);
//--------------------------------------------------------------------------------------------------------------------

			ps.setInt(1, 1006);
			ps.setString(2, "OnePlus 10 Pro");
			ps.setInt(3, 70999);
			ps.setString(4,"\n"
					+ "• Display     :- 17.02 cm Display\r\n"
					+ "• Front Camera:- 16MP \r\n"
					+ "• Rare Camera :- 48MP  Rear Camera\r\n"
					+ "• RAM         :- 8 GB RAM \r\n"
					+ "• Stroage     :-  128 GB ROM\r\n"
					+ "");
				
			ps.setInt(5, 100);
//-----------------------------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1007);
			ps.setString(2, "Samsung Galaxy S22 Plus");
			ps.setInt(3, 70000);
			ps.setString(4,"\n"
					+ "• Display     :- 16.76 cm Display\r\n"
					+ "• Front Camera:- 10MP\r\n"
					+ "• Rare Camera :- 50MP + 12MP + 10MP  Rear Camera\r\n"
					+ "• RAM         :- 8 GB RAM \r\n"
					+ "• Stroage     :-  128 GB ROM\r\n"
					+ "");
			ps.setInt(5, 100);
			
//---------------------------------------------------------------------------------------------------------------------		
			ps.setInt(1, 1008);
			ps.setString(2, "vivo X80 5G");
			ps.setInt(3, 54999);
			ps.setString(4,"\n"
					+ "• Display     :- 17.22 cm Display\r\n"
					+ "• Front Camera:-  32MP\r\n"
					+ "• Rare Camera :- 50MP + 12MP + 12MP Rear Camera\r\n"
					+ "• RAM         :- 8 GB RAM \r\n"
					+ "• Stroage     :-  128 GB ROM\r\n"
					+ "\r\n"
					+ "");
			ps.setInt(5, 100);
//-----------------------------------------------------------------------------------------------------------------------	
			ps.setInt(1, 1009);
			ps.setString(2, "vivo X70 Pro Plus");
			ps.setInt(3, 65999);
			ps.setString(4,"\n"
					+ "• Display :- 16.92 cm Display\r\n"
					+ "• Front Camera:-  32MP\r\n"
					+ "• Rare Camera :- 50MP + 12MP  Rear Camera\r\n"
					+ "• RAM :- 6 GB RAM \r\n"
					+ "• Stroage :-  128 GB ROM\r\n"
					+ "");
			ps.setInt(5, 100);
//-------------------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1010);
			ps.setString(2, "iQOO 9T 5G");
			ps.setInt(3, 96325);
			ps.setString(4,"\n"
					+ "• Display     :- 17.02 cm Display\r\n"
					+ "• Front Camera:-  64MP\r\n"
					+ "• Rare Camera :- 128  Rear Camera\r\n"
					+ "• RAM         :- 8 GB RAM \r\n"
					+ "• Storage     :-  264 GB ROM\r\n"
					+ "\r\n"
					+ "");
			ps.setInt(5, 100);
			
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	
			int i = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void display() {
		
			try {
				ConnectionTest test = new ConnectionTest();
				connection = test.getConnectionDetail();
			ps=connection.prepareStatement("select * from product order by product_id ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Mobile id        = "+rs.getInt(1));
				System.out.println("Mobile name      = "+rs.getString(2));
				System.out.println("Mobile price     = "+rs.getInt(3));
				System.out.println("Mobile Feature   ="+rs.getString(4));
				System.out.println("Mobile Quantity  = "+rs.getInt(5));
				System.out.println("\n");
				System.out.println("-------------------------------------------------------------------------");
				Thread.sleep(3000);
			}
			ps.close();
			rs.close();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
	}
}
	

