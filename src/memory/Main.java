///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package memory;
//
//import java.util.ArrayList;
//
///**
// *
// * @author lenovo
// */
//public class Main {
//    public static void main(String[] args) {
//        Memory memory = new IndexedMemory(20);
//                 memory.allocate(2) ;
//                 memory.allocate(6);
//                fn(memory);
//
//        int[] loc = {0,1,2};
//        memory.deallocate(loc);
//        memory.allocate(4);
//        fn(memory);
//        
//        
//
//        
//    }
//    
//    public static void fn(Memory memory){
//                System.out.print("Empty Space : ");       
//        System.out.println(memory.getFreeSize() + " Blocks");
//        
//        System.out.print("Allocated Space : ");
//        System.out.println(memory.getAllocatedSize() + " Blocks");
//        
//        System.out.println("Empty Blocks : ");
//        ArrayList <Integer> freeBlocks = memory.getFreeBlocks();
//        for(int i : freeBlocks)
//            System.out.println(i);
//        
//        System.out.println("Allocated Blocks : ");
//        ArrayList <Integer> allocatedBlocks = memory.getAllocatedBlocks();
//        for(int i : allocatedBlocks)
//            System.out.println(i);
//        
//        System.out.println("--------------------");
//    }
//}
