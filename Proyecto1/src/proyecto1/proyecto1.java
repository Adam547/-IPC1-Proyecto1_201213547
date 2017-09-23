package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.*;
import org.jfree.ui.ApplicationFrame;



public class proyecto1 extends JFrame  {
    public JLabel texto;
    public JLabel texto2;
    public JLabel texto3;
    public JTextField Usuario;  
    public JButton Inicio;
    public JButton Formulario;
    public JPasswordField Contraseña;
    public String Access;
    public String Pass;
    public static String Base_de_Datos[][]= new String[50][50];
    public String Recibos[][] = new String [50][50];
    public String Fechas[][] = new String[50][50];
    public String Check = "NO";
    public int Reg = 3;
    public int X;
    public int Log;
    public String Doscientos_Dinero = "15";
    public String Cien_Dinero = "15";
    public int Valor1 = 0;
    public int Valor2 = 0;
    public int Conversion;
    
    
	public static void main(String args[]){  
            Datos_Iniciales();
            Inicio();
	}
          public static void Inicio(){        
          proyecto1 ventana1 = new proyecto1();
          ventana1.show();
          }
  public proyecto1(){
    super();
    getContentPane().setBackground(new java.awt.Color(137,219,219));
    Datos_Iniciales();
    setSize(250, 300);
    setTitle("Bienvenido");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(null);
        texto = new JLabel();
        texto2 = new JLabel();
        texto3 = new JLabel();
        Usuario = new JTextField();
        Contraseña = new JPasswordField();
        Inicio = new JButton();
        Formulario = new JButton();
        texto.setText("Nombre de Usuario:"); 
        texto.setBounds(50, 50, 200, 25);  
        texto2.setText("Contraseña:"); 
        texto2.setBounds(50, 110, 100, 25);  
        texto3.setBounds(50, 170, 50, 25);  
        Usuario.setBounds(40, 75, 175, 30);
        Usuario.setText("ipc1Admin");
        Contraseña.setBounds(40, 140, 175, 30);
        Contraseña.setText("aux1");
        Inicio.setText("Iniciar Sesion");  
        Inicio.setBounds(65, 180, 120, 30);  // (x, y, ancho, alto)
        this.add(texto);
        this.add(texto2);
        this.add(texto3);
        this.add(Usuario);
        this.add(Contraseña);
        this.add(Inicio);
        Inicio.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Access= Usuario.getText();
            Pass = Contraseña.getText();
            Check = "NO";
            if (Access.equals("ipc1Admin") && Pass.equals("aux1")){
                    JOptionPane.showMessageDialog(null, "Bienvenido\n"
                    + "Bienvenido SuperUsuario",   "Acceso Correcto",
                    JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    SuperUsuario SU = new SuperUsuario();
                    SU.Administrar();
                   
            }else{
                for(int I = 0; I <= 20; I++){
                    if (Access.equals(Base_de_Datos[I][1]) && Pass.equals(Base_de_Datos[I][2])){
                    JOptionPane.showMessageDialog(null, "Bienvenido:\n"
                    + Base_de_Datos[I][4] + " " + "le da la Bienvenida" + " "+ Base_de_Datos[I][0],
                    "Acceso Correcto",
                    JOptionPane.INFORMATION_MESSAGE);
                    Log = I;
                    I = 20;
                    Check = "";
                    dispose();
                    Opciones OP = new Opciones();
                    OP.Operaciones();
                    break;
                    }
                }
                if (Check == "NO"){
                    JOptionPane.showMessageDialog(null, "Error:\n"
                    + "Por favor ingrese Nombre de Usuario y Contraseña correctos", "Acceso Denegado",
                    JOptionPane.ERROR_MESSAGE);
                    Usuario.setText("");
                    Contraseña.setText("");
            }
            }
        }
        });
  }
  public static void Datos_Iniciales(){
      Base_de_Datos[0][0] = "Adam Navas";
      Base_de_Datos[0][1] = "Adam547";
      Base_de_Datos[0][2] = "5624";
      Base_de_Datos[0][3] = "1500";
      Base_de_Datos[0][4] = "Cash-money";
      Base_de_Datos[0][5] = "5000";
      
      Base_de_Datos[1][0] = "Ashlie Tejada";
      Base_de_Datos[1][1] = "Ash93";
      Base_de_Datos[1][2] = "9191";
      Base_de_Datos[1][3] = "1000";
      Base_de_Datos[1][4] = "Pro-Pisto";
      Base_de_Datos[1][5] = "6000";
      
      Base_de_Datos[2][0] = "Lesly Canox";
      Base_de_Datos[2][1] = "LesCX";
      Base_de_Datos[2][2] = "3533";
      Base_de_Datos[2][3] = "3000";
      Base_de_Datos[2][4] = "Pro-Pisto";
      Base_de_Datos[2][5] = "8000";
      
      Base_de_Datos[3][0] = "Angela Rodriguez";
      Base_de_Datos[3][1] = "Angel23";
      Base_de_Datos[3][2] = "Hola1234";
      Base_de_Datos[3][3] = "800";
      Base_de_Datos[3][4] = "Cash-money";
      Base_de_Datos[3][5] = "6000";
      
  }
public class Opciones extends JFrame  {
    
    public JButton Saldo_Cuenta;
    public JButton Transferencia_estudiantes;
    public JButton Transferencia_Libre;
    public JButton Sistema_impresion;
    public JButton Grafica_pie;
    public JButton Grafica_barras;
    public JButton Retiro;
    public JButton Salir;
    public JLabel Logo;


        public void Operaciones(){
            Opciones ventana2 = new Opciones();
            ventana2.show();
  }
    public Opciones(){
        super();
        if (Base_de_Datos[Log][4]== "Pro-Pisto"){
            getContentPane().setBackground(new java.awt.Color(255,44,31));
        }else{
            getContentPane().setBackground(new java.awt.Color(26,158,33));
        }
        setSize(800, 600);
        setTitle("Menu Pricipal");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Saldo_Cuenta = new JButton();
        Transferencia_estudiantes = new JButton();
        Transferencia_Libre = new JButton();
        Sistema_impresion = new JButton();
        Grafica_pie = new JButton();
        Grafica_barras = new JButton();
        Retiro = new JButton();
        Logo = new JLabel();
        Salir = new JButton();
        Logo.setIcon(new ImageIcon("Logo.png"));
        Logo.setBounds(100, 100, 500, 500);
        Saldo_Cuenta.setText("Saldo de la Cuenta");
        Saldo_Cuenta.setBounds(50, 50, 200, 80);
        Transferencia_estudiantes.setText("Transferencia de Saldo entre estudiantes");
        Transferencia_estudiantes.setBounds(550, 50, 200, 80);
        Transferencia_Libre.setText("Transferencia Libre");
        Transferencia_Libre.setBounds(50, 150, 200, 80);
        Sistema_impresion.setText("Sistema de re-impresion");
        Sistema_impresion.setBounds(550, 150, 200, 80);
        Grafica_pie.setText("Grafica de Pie");
        Grafica_pie.setBounds(50, 250, 200, 80);
        Grafica_barras.setText("Grafica de Barras");
        Grafica_barras.setBounds(550, 250, 200, 80);
        Retiro.setText("Retiro de Efectivo");
        Retiro.setBounds(300, 350, 200, 80);
        Salir.setBounds(50, 500, 100, 50);
        Salir.setText("Salir");
        this.add(Saldo_Cuenta);
        this.add(Transferencia_estudiantes);
        this.add(Transferencia_Libre);
        this.add(Sistema_impresion);
        this.add(Grafica_pie);
        this.add(Grafica_barras);
        this.add(Retiro);
        this.add(Logo);
        this.add(Salir);
        Salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             proyecto1 PR = new proyecto1();
             PR.Inicio();
        }
        });
        Retiro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Transaccion TR = new Transaccion();
             TR.Cantidad();
        }
        });
        Saldo_Cuenta.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Estado_de_cuenta EC = new Estado_de_cuenta();
             EC.Estado();
        }
        });
        Transferencia_Libre.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Transferencia TR = new Transferencia();
             TR.Movimientos();
            }
        });
        Grafica_pie.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Grafica_Pie GP = new Grafica_Pie();
             GP.grafica();
            }
        });
    }
}
public class Estado_de_cuenta extends JFrame{
    public JLabel Saldo;
    public JLabel Banco;
    public JLabel Fecha;
    public JLabel Titulo;
    public JButton Aceptar;
    
    
        public void Estado(){
            Estado_de_cuenta ventana7 = new Estado_de_cuenta();
            ventana7.show();
        }
    public Estado_de_cuenta(){
        super();
        if (Base_de_Datos[Log][4]== "Pro-Pisto"){
            getContentPane().setBackground(new java.awt.Color(255,44,31));
        }else{
            getContentPane().setBackground(new java.awt.Color(26,158,33));
        }
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat();
        setSize(300, 300);
        setTitle("Estado de la cuenta");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Saldo = new JLabel();
        Banco = new JLabel();
        Fecha = new JLabel();
        Titulo = new JLabel();
        Aceptar = new JButton();
        Saldo.setText(Base_de_Datos[Log][3]);
        Banco.setText(Base_de_Datos[Log][4]);
        Fecha.setText(hourdateFormat.format(date));
        Titulo.setText("Saldo de la Cuenta:");
        Aceptar.setText("Aceptar");
        Banco.setBounds(110, 20, 110, 50);// (x, y, ancho, alto)
        Fecha.setBounds(20, 50, 280, 50);
        Titulo.setBounds(20, 80, 110, 50);
        Saldo.setBounds(110, 120, 110, 50);
        Aceptar.setBounds(100, 180, 100, 50);
        this.add(Banco);
        this.add(Fecha);
        this.add(Titulo);
        this.add(Saldo);
        this.add(Aceptar);
        Aceptar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Opciones OP = new Opciones();
             OP.Operaciones();
        }
        });
    }    
}
public class SuperUsuario extends JFrame  {
    
    public JButton Nuevo_Usuario;
    public JButton Dinero;
    public JButton Salir;


        public void Administrar(){
           SuperUsuario ventana3 = new SuperUsuario();
           ventana3.show();
  }
    public SuperUsuario(){
        super();
        getContentPane().setBackground(new java.awt.Color(137,219,219));
        setSize(500, 300);
        setTitle("SuperUsuario");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Nuevo_Usuario = new JButton();
        Dinero = new JButton();
        Salir = new JButton();
        Nuevo_Usuario.setText("Nuevo Registro de Usuario");
        Nuevo_Usuario.setBounds(150, 50, 200, 80);
        Dinero.setText("Existencia de Billetes");
        Dinero.setBounds(150, 150, 200, 80);
        Salir.setBounds(20, 150, 100, 50);
        Salir.setText("Salir");
        this.add(Nuevo_Usuario);
        this.add(Dinero);
        this.add(Salir);
        Nuevo_Usuario.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Registro RE = new Registro();
             RE.Registrar();
        }
        });
        Dinero.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             Billetes BI = new Billetes();
             BI.Actualizacion();
        }
        });
        Salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             proyecto1 PR = new proyecto1();
             PR.Inicio();
        }
        });
    }
  }
public class Registro extends JFrame  {
    public JLabel Texto;
    public JTextField Nombre_Usuario;
    public JLabel Texto2;
    public JTextField Contraseña;
    public JLabel Texto3;
    public JTextField User;
    public JLabel Texto4;
    public JTextField Saldo;
    public JLabel Texto5;
    public JTextField Banco;
    public JLabel Texto6;
    public JTextField Max_Saldo;
    public JButton Guardar;
    public JButton Salir;
    
    public void Registrar(){
        Registro ventana4 = new Registro();
            ventana4.show();
    }
    public Registro(){
        super();
        getContentPane().setBackground(new java.awt.Color(137,219,219));
        setSize(500, 500);
        setTitle("Registro de Nuevo Usuario");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Texto = new JLabel();
        Texto2 = new JLabel();
        Texto3 = new JLabel();
        Texto4 = new JLabel();
        Texto5 = new JLabel();
        Texto6 = new JLabel();
        Nombre_Usuario = new JTextField();
        Contraseña = new JTextField();
        User = new JTextField();
        Saldo = new JTextField();
        Banco = new JTextField();
        Max_Saldo = new JTextField();
        Guardar = new JButton();
        Salir = new JButton();
        Texto.setText("Nombre Completo:");
        Texto2.setText("Nombre de Usuario:");
        Texto3.setText("Contraseña:");
        Texto4.setText("Saldo Inicial:");
        Texto5.setText("Banco que lo Atiende:");
        Texto6.setText("Maximo Saldo:");
        Texto.setBounds(50, 50, 150, 30);
        Texto2.setBounds(50, 100, 150, 30);
        Texto3.setBounds(50, 150, 150, 30);
        Texto4.setBounds(50, 200, 150, 30);
        Texto5.setBounds(50, 250, 150, 30);
        Texto6.setBounds(50, 300, 150, 30);
        Nombre_Usuario.setBounds(200, 50, 150, 30);// (x, y, ancho, alto)
        User.setBounds(200, 100, 150, 30);
        Contraseña.setBounds(200, 150, 150, 30);
        Saldo.setBounds(200, 200, 150, 30);
        Banco.setBounds(200, 250, 150, 30);
        Max_Saldo.setBounds(200, 300, 150, 30);
        Guardar.setText("Guardar Registro");
        Guardar.setBounds(150, 350, 200, 70);
        Salir.setBounds(20, 400, 100, 50);
        Banco.setText("Cash-money/Pro-Pisto");
        Salir.setText("Salir");
        this.add(Texto);
        this.add(Texto2);
        this.add(Texto3);
        this.add(Texto4);
        this.add(Texto5);
        this.add(Texto6);
        this.add(Nombre_Usuario);
        this.add(Contraseña);
        this.add(User);
        this.add(Saldo);
        this.add(Banco);
        this.add(Max_Saldo);
        this.add(Guardar);
        this.add(Salir);
        Guardar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              Reg = Reg +1;
              Base_de_Datos[Reg][0]= Nombre_Usuario.getText();
              Base_de_Datos[Reg][1]= Contraseña.getText();
              Base_de_Datos[Reg][2]= User.getText();
              Base_de_Datos[Reg][3]= Saldo.getText();
              Base_de_Datos[Reg][4]= Banco.getText();
              Base_de_Datos[Reg][5]= Max_Saldo.getText();
              JOptionPane.showMessageDialog(null, "Guardado Finalizado:\n"
                    + "Se ha guardado Satisfactoriamente el Usuario",
                    "Sistema de Registro",
                    JOptionPane.INFORMATION_MESSAGE);
              Nombre_Usuario.setText("");
              Contraseña.setText("");
              User.setText("");
              Saldo.setText("");
              Banco.setText("Cash-money/Pro-Pisto");
              Max_Saldo.setText("");
        }
        });
        Salir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             dispose();
             SuperUsuario SU = new SuperUsuario();
             SU.Administrar();
        }
        });
    }

}
public class Billetes extends JFrame  {
    public JLabel Billete;
    public JTextField Doscientos;
    public JLabel Billete2;
    public JTextField Cien;
    public JButton Actualizar; 
    public JTextField Nuevo_Cien;
    public JTextField Nuevo_Doscientos;
    public JLabel Agregar;
    public JLabel Agregar2;
    
    public void Actualizacion(){
        Billetes ventana5 = new Billetes();
        ventana5.show();
    }
    
    public Billetes(){
        super();
        getContentPane().setBackground(new java.awt.Color(137,219,219));
        setSize(550, 300);
        setTitle("Existencia de Dinero");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Billete = new JLabel();
        Billete2 = new JLabel();
        Agregar = new JLabel();
        Agregar2 = new JLabel();
        Doscientos = new JTextField();
        Cien = new JTextField();
        Nuevo_Cien = new JTextField();
        Nuevo_Doscientos = new JTextField();
        Actualizar = new JButton();
        Billete.setBounds(100, 50, 150, 30);
        Billete.setText("Billetes de 200");
        Billete2.setBounds(350, 50, 150, 30);
        Billete2.setText("Billetes de 100");
        Doscientos.setBounds(120, 90, 50, 30);
        Doscientos.setText(Doscientos_Dinero);
        Doscientos.setEditable(false);
        Nuevo_Doscientos.setBounds(120, 130, 50, 30);
        Cien.setBounds(370, 90, 50, 30);
        Cien.setText(Cien_Dinero);
        Cien.setEditable(false);
        Agregar.setText("Agregar:");
        Agregar.setBounds(60, 130, 50, 30);
        Agregar2.setText("Agregar:");
        Agregar2.setBounds(310, 130, 50, 30);
        Nuevo_Cien.setBounds(370, 130, 50, 30);
        Actualizar.setBounds(180, 180, 180, 50);
        Actualizar.setText("Agregar Existencias");
        this.add(Billete);
        this.add(Billete2);
        this.add(Doscientos);
        this.add(Cien);
        this.add(Nuevo_Cien);
        this.add(Nuevo_Doscientos);
        this.add(Actualizar);
        this.add(Agregar);
        this.add(Agregar2);
        Actualizar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int Suma = Integer.parseInt(Doscientos_Dinero)+Integer.parseInt(Nuevo_Doscientos.getText());
            int Suma2 = Integer.parseInt(Cien_Dinero)+Integer.parseInt(Nuevo_Cien.getText());
            Doscientos_Dinero = Integer.toString(Suma);
            Cien_Dinero = Integer.toString(Suma2);
            JOptionPane.showMessageDialog(null, "Aviso:\n"
                    + "Se han cargado los nuevos billetes a la maquina","Actualizacion",
                    JOptionPane.INFORMATION_MESSAGE);
             Doscientos.setText(Doscientos_Dinero);
             Cien.setText(Cien_Dinero);
             Nuevo_Doscientos.setText("");
             Nuevo_Cien.setText("");
             
        }
        });
    }
}
public class Transaccion extends JFrame{
    public JButton Cien;
    public JButton Doscientos;
    public JButton Trescientos;
    public JButton Quinientos;
    public JButton Mil;
    public JButton Personal;


    public void Cantidad() {
        Transaccion ventana6 = new Transaccion();
        ventana6.show();
    }
    
    public Transaccion(){
        super();
        if (Base_de_Datos[Log][4]== "Pro-Pisto"){
            getContentPane().setBackground(new java.awt.Color(255,44,31));
        }else{
            getContentPane().setBackground(new java.awt.Color(26,158,33));
        }
        setSize(800, 400);
        setTitle("Monto Deseado:");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Cien = new JButton();
        Doscientos = new JButton();
        Trescientos = new JButton();
        Quinientos = new JButton();
        Mil = new JButton();
        Personal = new JButton();
        Cien.setText("100");
        Cien.setBounds(50, 50, 200, 80);// (x, y, ancho, alto)
        Doscientos.setText("200");
        Doscientos.setBounds(550, 50, 200, 80);
        Trescientos.setText("300");
        Trescientos.setBounds(50, 150, 200, 80);
        Quinientos.setText("500");
        Quinientos.setBounds(550, 150, 200, 80);
        Mil.setText("1000");
        Mil.setBounds(50, 250, 200, 80);
        Personal.setText("Otra Cantidad");
        Personal.setBounds(550, 250, 200, 80);
        this.add(Cien);
        this.add(Doscientos);
        this.add(Trescientos);
        this.add(Quinientos);
        this.add(Mil);
        this.add(Personal);
        Cien.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             Valor1 = Integer.parseInt("100") / 100;
             Conversion = Integer.parseInt(Base_de_Datos[Log][3]) - 100;
             Base_de_Datos[Log][3] = Integer.toString(Conversion);
             Recibo RE = new Recibo();
             RE.Recibos();
        }
        });
        Doscientos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             Valor1 = Integer.parseInt("200") / 100;
             Conversion = Integer.parseInt(Base_de_Datos[Log][3]) - 100;
             Base_de_Datos[Log][3] = Integer.toString(Conversion);
             Recibo RE = new Recibo();
             RE.Recibos();

        }
        });
        Trescientos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             Valor1 = Integer.parseInt("300") / 100;
             Conversion = Integer.parseInt(Base_de_Datos[Log][3]) - 300;
             Base_de_Datos[Log][3] = Integer.toString(Conversion);
             Recibo RE = new Recibo();
             RE.Recibos();

        }
        });
        Quinientos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             Valor1 = Integer.parseInt("500") / 100;
             Conversion = Integer.parseInt(Base_de_Datos[Log][3]) - 500;
             Base_de_Datos[Log][3] = Integer.toString(Conversion);
             Recibo RE = new Recibo();
             RE.Recibos();

        }
        });
        Mil.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             Valor1 = Integer.parseInt("1000") / 100;
             Conversion = Integer.parseInt(Base_de_Datos[Log][3]) - 1000;
             Base_de_Datos[Log][3] = Integer.toString(Conversion);
             Recibo RE = new Recibo();
             RE.Recibos();

        }
        });
    }
}
public class Recibo{
    
    public void Recibos(){
        System.out.println("llego aqui la accion");
        Recibo X = new Recibo();
    
    }
    
    public Recibo(){
    try{ 
        File archivo = new File("Transaccion.html");
        FileWriter Recibo = new FileWriter(archivo,true); 
        PrintWriter Formato = new PrintWriter(archivo);
        Formato.println("html>");
        Formato.println("<Head>");
        Formato.println("<title>Transaccion:</title>");
        Formato.println("/<Head>");
        Formato.println(" <h1><center>Gracias por su retiro, se le ha entregado:</center></h1>");
        Formato.println("<h2> Billetes de 200 = "+ Valor2 + "</h2>");
        Formato.println("<h2> Billetes de 100 = "+ Valor1 + "</h2>");
        Formato.println(" </body>");
        Formato.println("</html>");
        Formato.close();
        } catch(Exception e){
        e.printStackTrace();
    }
    }
    }
    public class Grafica_Pie extends JFrame{
 
        
        public void grafica(){

        
    
    }  
        }
    public class Transferencia extends JFrame{
        public JComboBox Alumnos;
        public JTextField Cantidad;
        public JButton Aceptar;
        
            public void Movimientos(){
                Transferencia ventana8 = new Transferencia();
                ventana8.show();
            }
    public Transferencia(){
        super();
        if (Base_de_Datos[Log][4]== "Pro-Pisto"){
            getContentPane().setBackground(new java.awt.Color(255,44,31));
        }else{
            getContentPane().setBackground(new java.awt.Color(26,158,33));
        }
        setSize(500, 500);
        setTitle("Transferencia de Alumnos:");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        Alumnos = new JComboBox();
        Cantidad = new JTextField();
        Aceptar = new JButton();
        Alumnos.setBounds(100,200,250,50);
            for (int y = 1; y <= 40; y++){
                if (Base_de_Datos[y][0]!= null){
                Alumnos.setModel(new DefaultComboBoxModel(new String[] {Base_de_Datos[y][0]}));
                } 
            }
        Cantidad.setBounds(150,250,150,50);
        Aceptar.setBounds(150, 350, 150, 50);
        Aceptar.setText("Aceptar");
        this.add(Alumnos);
        this.add(Cantidad);
        this.add(Aceptar);
    }        

    }
}