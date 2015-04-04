package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ZomatoCrawler {

	public static void main(String[] args) {
		
		//String url = "zomato URL";
		Document doc = null;
		//String zomatoUrl = "https://www.zomato.com/bangalore/koramangala-restaurants?category=1";
		String zomatoUrl = "https://www.zomato.com/bangalore/whitefield-restaurants?category=2";
		try {
			doc = (Document) Jsoup.connect(zomatoUrl).timeout(40000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element mainframe  = doc.getElementById("mainframe");
		
		Elements searchResultAllClass = mainframe.getElementsByClass("search-result-all");
		
		for(Element aSearchResultAll : searchResultAllClass) {
			
			String href = null;
			String restrauName = null;
			String address = null;
			String area = null;
			String ratings = null;
			String tags = null;
			String imageUrl = null;
			
			Elements article = aSearchResultAll.getElementsByTag("article");				//article journal
			for(Element anArticle : article) {
				//header tag
				Elements h3Articles = anArticle.getElementsByTag("h3");						//header tag
				for(Element oneH3Article : h3Articles) {
					Elements aArticles = oneH3Article.getElementsByTag("a");
					for(Element oneAArticle : aArticles) {
						href  = oneAArticle.attr("href");					//getting the href elemement
						restrauName = oneAArticle.text();							//restrraunt name
					}
				}
				
				Elements areaClass = anArticle.getElementsByClass("mt2");
				for(Element anAreaClass : areaClass) {
					Elements spanElement = anAreaClass.getElementsByTag("span");
					for(Element oneSpanElement : spanElement) {
						//address = oneAElement.text();							//ratings
						address = oneSpanElement.attr("title");
					}
					
					Elements aElement = anAreaClass.getElementsByTag("a");
					for(Element oneAElement : aElement) {
						area = oneAElement.text();							//ratings
						//address = oneAElement.attr("title");
					}
					
				}
				
				//right ratings
				Elements rightClass = anArticle.getElementsByClass("right");
				for(Element anRightClass : rightClass) {
					Elements rightClassTooltip = anRightClass.getElementsByClass("tooltip");
					for(Element anRightClassTooltip : rightClassTooltip) {
						ratings = anRightClassTooltip.text();							//ratings
					}
				}
				Elements typeOfRestrauant = anArticle.getElementsByClass("search_grid_left").addClass("search_grid_100").eq(1);
				for(Element oneTypeOfRestrauant : typeOfRestrauant) {
					Elements finalTypeOfRestrau = oneTypeOfRestrauant.getElementsByClass("res-snippet-small-cuisine").addClass("truncate").addClass("search-page-text").eq(1);
					for(Element aFinalTypeOfRestrau : finalTypeOfRestrau) {
						String[] restrauantTypes = aFinalTypeOfRestrau.text().split("›");
						if(restrauantTypes.length == 2)
							tags = aFinalTypeOfRestrau.text().split("›")[1];
					}
				}
				
				//lat long
				//String location = restrauName + "," + area;
				String[] latLong = new String[2];
				try {
					latLong = GMaps.getLatLongPositions(address);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Document hrefDoc = null;
				try {
					hrefDoc = (Document) Jsoup.connect(href).timeout(40000).get();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Element newMainframe  = hrefDoc.getElementById("mainframe");
				
				Elements resInfoThumbs = newMainframe.getElementsByClass("res-info-thumbs");
				
				Boolean flag = true;
				for(Element aResInfoThumbs : resInfoThumbs) {
					if(!flag)
						break;
					Elements sourceImage = aResInfoThumbs.getElementsByTag("img");
					for(Element anImage : sourceImage) {
						imageUrl  = anImage.attr("src");
						flag = false;
						continue;
					}
				}
				
				
				
				System.out.println(restrauName +  "|" + latLong[0] +  "|"  + latLong[1] + "|" + address + "|" + tags + "|" + ratings + "|" + href + "|" + imageUrl);
			}
		}
		
	}
}
