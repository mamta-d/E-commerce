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
			ps.setInt(3, 419633);
			ps.setString(4,
					"The latest Apple iPhones are here and the lineup is headlined by the all-new iPhone 13 Pro Max."
					+ " This time around, Apple has finally furnished its top dog with a 120Hz high-refresh rate\n "
					+ "display along with a more powerful custom silicon in the form of the A15 Bionic SoC.\n "
					+ "It also helps that the smartphone offers newer imaging sensors that click stunning images\n"
					+ " come night or day. Apple has also incorporated some new features with the iPhone 13 lineup\n "
					+ "including a Cinematic Video mode, as well as Photographic styles that will undoubtedly\n"
					+ " elevate a user's photography and cinematography experience.");
			ps.setInt(5, 100);
//----------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1002);
			ps.setString(2, "Samsung Galaxy S22 Ultra");
			ps.setInt(3, 90400);
			ps.setString(4,
					"The Samsung Galaxy S22 Ultra is the most loaded flagship from the companyâ€™s stables yet, scoring high on most aspects like performance, cameras and usage experience. The included S Pen acts as the cherry on top, and is a highly useful accessory to have.");
			ps.setInt(5, 100);
//----------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1003);
			ps.setString(2, "vivo X80 Pro Plus 5G");
			ps.setInt(3, 82990);
			ps.setString(4,
					"Currently the Vivo X80 Pro is arguably the best phone in the market for photography. It has a superlative camera array consisting of a 50MP Samsung GNV sensor, a 48MP ultra-wide shooter and a 5X persicope lens. With an array of features on offer for photography and videography, the X80 Pro is the most verstaile phone in the camera department. It also packs in the latest specs including a Snpadragon Gen 1 chipset, a WQHD+ 120Hz E5 AMOLED panel and up to 80W of charging speeds.");
			ps.setInt(5, 100);
//-----------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1004);
			ps.setString(2, "Samsung Galaxy Z Fold 4 5G");
			ps.setInt(3, 134899);
			ps.setString(4,
					"Samsung has truly refined the fodling smartphone experience with the Galaxy Z Fold4. While being an incremental update from the Fold 3, the device still has top-of-the-line processing capabilties, S-pen support, five cameras and more for a truly flagship experience. The inner screen is 120Hz AMOLED that opens up to measure 7.4-inch while on the front Samsung keeps the 6.2-inch panel. As for optics, there is a 4MP under-display camera on the inside, 10MP on the cover screen and a triple-camera setup on the back. All of this is kept running thanks to a 4,400mAh battery.");
			ps.setInt(5, 100);
//--------------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1005);
			ps.setString(2, "Xiaomi 12 Pro 5G");
			ps.setInt(3, 54999);
			ps.setString(4,
					"The OnePlus brand has never been on top of the photography charts when compared to other premium flagship brands. With the OnePlus 10 Pro, the company is trying to redeem its brand value. The device packs in a triple-camera setup with the 48MP primary sensor from Sony's stable while the 50MP ultra-wide comes from Samsung. The phone has the backing of Qualcomm's flagship Snapdragon 8 Gen 1 along with support for fast 80W charging speeds. Alongside that the device also packs in a top-notch, super brightt WQHD+ 120Hz panel for the optimum viewing experience");
			ps.setInt(5, 100);
//--------------------------------------------------------------------------------------------------------------------

			ps.setInt(1, 1006);
			ps.setString(2, "OnePlus 10 Pro");
			ps.setInt(3, 54999);
			ps.setString(4,
					" The OnePlus brand has never been on top of the photography charts when compared to other premium flagship brands. With the OnePlus 10 Pro, the company is trying to redeem its brand value. The device packs in a triple-camera setup with the 48MP primary sensor from Sony's stable while the 50MP ultra-wide comes from Samsung. The phone has the backing of Qualcomm's flagship Snapdragon 8 Gen 1 along with support for fast 80W charging speeds. Alongside that the device also packs in a top-notch, super brightt WQHD+ 120Hz panel for the optimum viewing experience.");
			ps.setInt(5, 100);
//-----------------------------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1007);
			ps.setString(2, "Samsung Galaxy S22 Plus");
			ps.setInt(3, 65999);
			ps.setString(4,"Samsung has the knack of releasing phones that set the benchmark for other flagship devices early in the year. The Galaxy S22 Plus continues the trend with its top-notch cameras, fast processing and the best-in-class display. For the first time the Galaxy S series is getting a flagship Qualcomm chipset in the form of the Snapdragon Gen 1 and it is paired with 8GB of LPDDR5 RAM. The 50MP camera is supported by a 3X telephoto and 12MP ultra-wide shooter. A 120Hz FHD+ AMOLED panel sets the bar high for viewing experience. Finaly there is the 4,500mAh battery with up to 45W charging support.");
			ps.setInt(5, 100);
			
//---------------------------------------------------------------------------------------------------------------------		
			ps.setInt(1, 1008);
			ps.setString(2, "vivo X80 5G");
			ps.setInt(3, 54999);
			ps.setString(4," The Vivo X80 is not marketed as the company's marquee flagship offering but it does hold on its own against the competition. It is powered by MediaTek's flagship Dimensity 9000 SoC making it one of the fastest phones on the planet. While the X80 does not have the same camera capabiliies as its Pro moniker, the hardware it does have puts it easily in the top 10 camera phones on the market. The device supports a FHD+ 120Hz E5 AMOLED display with extreme colour accuracy, HDR10+ support and high brightness. Lastly, the 4,500mAh battery can be juiced up at 80W speeds.");
			ps.setInt(5, 100);
//-----------------------------------------------------------------------------------------------------------------------	
			ps.setInt(1, 1009);
			ps.setString(2, "vivo X70 Pro Plus");
			ps.setInt(3, 65999);
			ps.setString(4,"Vivo recently forayed into the premium segment with the X-series of phones. We have already been mighty impressed with the company's X60 Pro Plus and this year, the brand one-upped the competition with the X70 Pro Plus which improves upon its predecessor and offers both, wireless charging as well as IP rating. What's more, the device also comes with a phenomenal camera setup that is headlined by a 48MP Gimbal camera and a 50MP main sensor. Rest assured, if you want a capable Android that can do justice to stills as well as videos, then you cannot go wrong with the X70 Pro Plus.");
			ps.setInt(5, 100);
//-------------------------------------------------------------------------------------------------------------------------
			ps.setInt(1, 1010);
			ps.setString(2, "iQOO 9T 5G");
			ps.setInt(3, 96325);
			ps.setString(4,"The iQOO 9T has the Qualcomm Snapdragon 8+ Gen 1 SoC at the helm for processing needs, making it one of the fastest phones on the planet. It ships with a 6.78-inch, FHD+, E5 AMOLED panel that can refresh at 120Hz and also has a dedicated V1+ chip for visual enhancements. As for cameras the 50MP GN5 handles primary image taking responsibilites supported by a 13MP ultra-wide and 12MP portrait lens. Combined with stereo speakers, 120W fast charging and more, the iQOO 9T is a top recommendation.");
			ps.setInt(5, 100);
			int i = ps.executeUpdate();
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void display() {
		
			try {
				ConnectionTest test = new ConnectionTest();
				connection = test.getConnectionDetail();
			ps=connection.prepareStatement("select * from product order by price asc ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Mobile id        ="+rs.getInt(1));
				System.out.println("Mobile name      ="+rs.getString(2));
				System.out.println("Mobile price     ="+rs.getInt(3));
				System.out.println("Mobile name      ="+rs.getString(4));
				System.out.println("Mobile Quantity  ="+rs.getInt(5));
				System.out.println();
			}
			ps.close();
			rs.close();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
}
	

