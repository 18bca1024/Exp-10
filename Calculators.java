import java.awt.*;
import java.awt.event.*;


class Calculators extends Frame implements ActionListener,ItemListener
{
    TextField txt;
    Button btn[]=new Button[18];
      Choice ch;

    Calculators()
    {
        setTitle("Background Color");
        setLayout(null);
        setSize(400,300);

         txt= new TextField();
        txt.setSize(320,30);
        txt.setLocation(30,50);
        add(txt);

            int x=30, y=120;

        for(int i=1;i<13;i++)
        {
            btn[i] =new Button(String.valueOf(i));
            btn[i].setSize(70,20);
            btn[i].setLocation(x,y);
            add(btn[i]);
            btn[i].addActionListener(this);

            if(x>160)
            {
                x=30;
                y=y+35;
            }
            else
            {
                x+=83;
            }
            if(i==11)
            {
                btn[i].setLabel("0");
            }
            else if(i==10)
            {
                btn[i].setLabel(".");
            }
            else if(i==12)
            {
                btn[i].setLabel("=");
            }
        }
            y=120;
            for(int i=13;i<18;i++)
            {
                btn[i] =new Button(String.valueOf(i));
                btn[i].setSize(70,20);
                btn[i].setLocation(279,y);
                y=y+35;
                add(btn[i]);
                btn[i].addActionListener(this);

                if(i==13)
                {
                    btn[i].setLabel("+");
                }else if(i==14)
                {
                    btn[i].setLabel("-");
                }else if(i==15)
                {
                    btn[i].setLabel("x");
                }else if(i==16)
                {
                    btn[i].setLabel("/");
                }else if(i==17)
                {
                    btn[i].setLabel("Clear");
                }
            }

            Color clr=Color.white;

        setBackground(clr);

        ch=new Choice();
        ch.setBounds(196,230,80,80);
        ch.addItem("White");
        ch.addItem("Yellow");
        ch.addItem("Cyan");
        ch.addItem("Blue");
        ch.addItem("Red");
        add(ch);
        ch.addItemListener(this);

        Label l=new Label("To change the BG color:");
            l.setSize(180,20);
            l.setLocation(40,260);
            add(l);
        
          setVisible(true);




    }
    String s="";
    int d=0;
    float a[]=new float[4];
    char c;
    public void actionPerformed(ActionEvent e)
    {
        for(int i=1;i<12;i++)
        {
            
            if(e.getSource().equals(btn[i]))
            {
                if(i==11)
                {
                 s+="0";
                    
                }
                else if(i==10)
                {
                    s+='.';
                }
                else if(i==17)
                {
                    s="";
                }
                
                else
                {
                s+=String.valueOf(i);
                }
                
                
                txt.setText(s); 
                

            }
             

        }
        
            
            a[d] = Float.parseFloat(s);
             
                if(e.getSource().equals(btn[17]))
                {
                    a[0]=0;
                    a[1]=0;
                    s=" ";
                    txt.setText(String.valueOf(a[0])); 
                    d=0;
                }
                
                
                    if(e.getSource().equals(btn[13]))
                    {

                            d++;
                            s="";
                            a[0]+=a[1];
                            txt.setText(String.valueOf(a[0])); 

                            c='+';   
                            

                    }
                    else if(e.getSource().equals(btn[14]))
                    {
                            //.setText(String.valueOf(a[0])); 

                            d++;
                            s="";
                            a[0]-=a[1];

                            txt.setText(String.valueOf(a[0])); 
                            

                            c='-';   

                    }
                    else if(e.getSource().equals(btn[15]))
                    {
                            d++;
                            s="";
                            a[0]*=a[1]; 

                            txt.setText(s); 
                            c='x';  

                    }
                    else if(e.getSource().equals(btn[16]))
                    {
                            d++;
                            s="";
                            a[0]/=a[1];

                            txt.setText(s); 
                            c='/';   

                    }
                    else if(e.getSource().equals(btn[12]))
                        {
                            if(c=='+')
                            {
                            
                            a[0]+=a[1];
                                
                            txt.setText(String.valueOf(a[0])); 
                            d=1;
                            a[1]=0;
                            }
                            else if(c=='-')
                            {
                            
                            a[0]-=a[1];
                                
                            txt.setText(String.valueOf(a[0])); 
                            d=1;
                            a[1]=0;
                            }if(c=='x')
                            {
                            
                            a[0]*=a[1];
                                
                            txt.setText(String.valueOf(a[0])); 
                            d=1;
                            a[1]=0;
                            }if(c=='/')
                            {
                            
                            a[0]/=a[1];

                            txt.setText(String.valueOf(a[0])); 
                            d=1;
                            a[1]=0;
                            }
                                
                            
                        
                        }
                
            if(d==2)
            {
                d=1;
                                            a[1]=0;

            }


            
            
               

            
            

        
        
    }

        public void itemStateChanged(ItemEvent e)
    {
        if(e.getItem()=="Red")
        {
            Color clr=Color.red;
            setBackground(clr);


        }
        else if(e.getItem()=="Blue")
        {
            Color clr=Color.blue;
            setBackground(clr);


        }else if(e.getItem()=="White")
        {
            Color clr=Color.white;
            setBackground(clr);


        }else if(e.getItem()=="Yellow")
        {
            Color clr=Color.yellow;
            setBackground(clr);


        }else if(e.getItem()=="Cyan")
        {
            Color clr=Color.cyan;
            setBackground(clr);


        }

    }


    
}
class Tester
{

    public static void main(String args[])
    {
        Calculators c= new Calculators();
        //c.actionPerformed();
    
    }
}

