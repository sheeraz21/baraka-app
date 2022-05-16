//package com.baraka.candles.util;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import com.baraka.candles.dto.CandleList;
//
//public class StockDetailsMain {
//	
//	public  static Map<String,List<StockDetailsValue>> getStockDetails(String key,List<CandleList>  stockDetailList) {
//		Map<String,List<StockDetailsValue>> stockValue=new HashMap<String,List<StockDetailsValue>>();
//		List<StockDetailsValue> stockValueList=new ArrayList<StockDetailsValue>();
//		StockDetailsValue stockDetailsValue=new  StockDetailsValue();
//		List<CandleList>  stockDetailListAfterFilter=stockDetailList.stream().filter(value->value.getS().equalsIgnoreCase(key)).collect(Collectors.toList());
//		stockDetailsValue.setOpen(stockDetailListAfterFilter.get(0).getP());
//		stockDetailsValue.setClose(stockDetailListAfterFilter.get(stockDetailListAfterFilter.size()-1).getP());
//		stockDetailsValue.setHighValue(stockDetailListAfterFilter.stream()
//                .max(Comparator.comparingDouble(CandleList::getP)).get().getP());
//		stockDetailsValue.setLowValue(stockDetailListAfterFilter.stream()
//                        .min(Comparator.comparingDouble(CandleList::getP)).get().getP());
//		stockValueList.add(stockDetailsValue);
//		stockValue.put(key, stockValueList);
//		return stockValue; 
//	}
//
//	public static void main(String[] args) {
//		CandleList stockDetails1=new CandleList();
//		List<CandleList> stockDetailList=new ArrayList<CandleList>();
//		stockDetails1.setS("EWZS");
//		stockDetails1.setP(97.89242151625908);
//		stockDetails1.setT(1652167809924L);
//		stockDetails1.setV(10);
//		
//	
//		
//		CandleList stockDetails2=new CandleList();
//		stockDetails2.setS("EWZS");
//		stockDetails2.setP(65.18121870620641);
//		stockDetails2.setT(1652168402183L);
//		stockDetails2.setV(10);
//		
//		CandleList stockDetails3=new CandleList();
//		stockDetails3.setS("EWZS");
//		stockDetails3.setP(98.02558047321004);
//		stockDetails3.setT(1652168402183L);
//		stockDetails3.setV(10);
//		
//		
//		stockDetailList.add(stockDetails1);
//		stockDetailList.add(stockDetails2);
//		stockDetailList.add(stockDetails3);
//		StockDetailsMain companyDetails=new StockDetailsMain();
//		
//		Map<String,List<StockDetailsValue>> stockValueMap=companyDetails.getStockDetails("EWZS",stockDetailList);
//		List<StockDetailsValue> finalStockList;
//        Iterator<Map.Entry<String,List<StockDetailsValue>>> itr = stockValueMap.entrySet().iterator();
//        while(itr.hasNext())
//        {
//             Map.Entry<String, List<StockDetailsValue>> entry = itr.next();
//             System.out.println("Key = " + entry.getKey());
//             finalStockList=  entry.getValue();
//             finalStockList.stream().forEach(value->{
//            	 System.out.println(" Higest Value = " + value.getHighValue());
//    			 System.out.println(" Lowest Value = " + value.getLowValue());
//    			 System.out.println( " Close Value = " + value.getClose());
//    			 System.out.println(" Open Value = " + value.getOpen()); 
//            	 
//             });
//             
//        }
//    }
//	
//		
//	}
//
//
