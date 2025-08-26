package pe.edu.upeu.conceptospoo.claseinterna;

import java.util.concurrent.Callable;

public class ClaseExtrena {
    int a,b;

    int operacion(){
        return a+b;
    }
    class ClaseInterna1{
        int r;
        void mensaje(){
            r=a+b;
            System.out.println("la suma es:"+ r);
        }
    }
    class ClaseInterna2{
        void otraOperacion(){
            System.out.println("La operacion es:"+(a-b));
        }
    }


    public static void main(String[] args) {
        ClaseExtrena ce =new ClaseExtrena();
        ce.a=8;
        ce.b=2;
        System.out.println("la operacion es:"+ce.operacion());
        ClaseInterna1 ci1=ce.new ClaseInterna1();
        ci1.mensaje();
        ClaseInterna2 ci2=ce.new ClaseInterna2();
        ci2.otraOperacion();
            }
        }

 class ClaseExternX{

 }
 class ClaseInternaY{

 }
