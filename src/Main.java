

import java.lang.Character;
public class Main {
        public static void main(String[] args) {
                BT bt = new BinarTree();
                bt.add(500);
                bt.add(200);
                bt.add(700);
                bt.add(-100);
                bt.add(-200);
                bt.add(0);
                bt.add(300);
                bt.add(400);
                bt.add(600);
                bt.add(800);
                bt.add(205);
                bt.add(206);
                bt.add(202);
                bt.add(203);
                bt.add(201);

                //bt.delete(3);
               /* bt.add(0);
              //  bt.print();
                bt.add(5);
                bt.add(4);
                bt.add(100);
                bt.add(2);
                bt.add(-9);
                bt.add(-4);
                bt.add(-10);
                bt.add(-100);
                bt.add(-99);
                bt.add(3);
                System.out.println(bt.search(999999));
                System.out.println("MAX == " + bt.findMax());
                System.out.println("MIN == " + bt.findMin());
                bt.print();
                //bt.delete(-10);
              //  bt.print();
                //bt.delete(4);
                bt.delete(0);*/
                bt.print();
                bt.delete(200);
                bt.print();
                bt.add(204);
                bt.print();
                bt.delete(201);
                bt.print();
                bt.obhodS(bt.findNode());
                /*System.out.println();
                bt.obhodP(bt.findNode());
                System.out.println();
                bt.obhodO(bt.findNode());*/
        }
}
