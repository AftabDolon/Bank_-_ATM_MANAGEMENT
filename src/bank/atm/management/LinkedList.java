/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.atm.management;

import bank.atm.management.image.Bank;

/**
 *
 * @author Administrator
 */
class Node{
    private Node next, pre;
    private Bank customer, cnic ;
    public Node(Node next, Node pre, Bank customer, Bank cnic){
        this.next=next;
        this.pre=pre;
        this.customer=customer;
        this.cnic=cnic;
    }
    public Node(){
        next=null;
        pre=null;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next=next;
    }
    public Node getPre(){
        return pre;
    }
    public void setPre(Node pre){
        this.pre=pre;
    }
    public Bank getCustomer(){
        return customer;
    }
    public void setCustomer(Bank customer){
        this.customer=customer;
    }
    
}
public class LinkedList {
   Node head, tail;
   public LinkedList(){
       this.head=null;
       this.tail=null;
   }
   public void insert(Bank customer){
       Node node=new Node();
       node.setCustomer(customer);
       if(head==null|| tail==null){
           head=node;
           tail=node;
       }else{
           head.setNext(node);
           node.setPre(head);
           head=node;
       }
   }
   public Bank getInfo(String cnic){
       Node temp=head;
       while(temp!=null){
           if(cnic.equals(temp.getCustomer().getCnic()))
               return temp.getCustomer();
               temp=temp.getPre();
       }return null;
   }
   public int size(){
       Node temp=head;
       int size=0;
       while(temp!=null){
           size++;
           temp=temp.getPre();
       }return size;
   }
   public String allData(){
       Node temp=head;
       String data="";
       while(temp!=null){
           data+=temp.getCustomer().toString()+"\n";
           temp=temp.getPre();
       }return data;
   }
  public boolean check(String card){
       Node temp=head;
       while(temp!=null){
           if(card.equals(temp.getCustomer().getCard())){
               return true;
           }temp=temp.getPre();
       }return false;
   }
  public boolean isExit(String text){
       Node temp=head;
       while(temp!=null){
           if(text.equals(temp.getCustomer().getCnic())){
               return true;
           }temp=temp.getPre();
       }return false;
   }
  public String CnicInfo(String text){
       Node temp=head;
       while(temp!=null){
           if(text.equals(temp.getCustomer().getCnic())){
               return "\nCNIC\t\t"+temp.getCustomer().getCnic()+"\nName \t\t"+temp.getCustomer().getName()
                       +"\nPIN\t\t"+temp.getCustomer().getPin()
                       +"\nCard#\t\t"+temp.getCustomer().getCard()
                       +"\nAccount#\t\t"+temp.getCustomer().getAccountNo()
                       +"\nBalance\t\t"+temp.getCustomer().getBalance();
           }temp=temp.getPre();
       }return "";
   }
 public  String Deposit(String text, double amount){
       Node temp=head;
       while(temp!=null){
           if(text.equals(temp.getCustomer().getCnic())){
               temp.getCustomer().deposit(amount);
               return "";
           }temp=temp.getPre();
       }return "";
   }
   void withdraw(Bank cuss){
       Node temp=head;
       while(temp!=null){
           if(cuss.getCnic().equals(temp.getCustomer().getCnic())){
               temp.setCustomer(cuss);
               break;
           }
           temp=temp.getPre();
       }
   }
   Bank checkPInCard(String text, String text0){
       Node temp=head;
       while(temp!=null){
           if(text.equals(temp.getCustomer().getPin()+"")&& text0.equals(temp.getCustomer().getCard())){
               return temp.getCustomer();
           }
           temp=temp.getPre();
       }return null;
   }
   
}

