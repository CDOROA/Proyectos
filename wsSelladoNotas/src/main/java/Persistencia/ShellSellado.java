package Persistencia;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ShellSellado {
	public static String sellaCFDI(String uname,  String serie,String folio,String impresora) 
    {
        //Log log=new Log(1,Integer.parseInt(cadenaPedido.substring(0, 1)),Integer.parseInt(cadenaPedido.substring(1,6)),Integer.parseInt(cadenaPedido.substring(14,20)),"Inicia llamado a SWPedidosWWW" );
        //System.out.println(log);

        // Cls_Log.insertaLog(connBD, log);

        // cadenaPedido 
        //01 : 01 Centro
        //02 : 05 Num. Cte.
        //07 : 08 Fecha Pedido
        //15 : 06 Numero PEdido 
		String ruta="/usr/acct/roa/apsh";
		if(uname.equalsIgnoreCase("cdf")||uname.equalsIgnoreCase("cd2")) {
			 ruta="/usr/acct/centdis/apsh";
		}
		//System.out.print(serie+" "+folio+" "+impresora+" "+uname);
        //  PARA PRUEBAS
//        String host="DES"+uname.toUpperCase();
//        String user="desmay";
//        String password="M261086";

        // PRODUCCION
      String host=uname;
      String user="desmay";
      String password="M261086";

        //System.out.println("conectdo a: " + host );

        String rsp = "false";
//        String command1="cd "+origen;
//        command1 += "cp "+nota+" "+destino;
//        command1 += "; exit";
       // log.setAccion("wsPedidosWWW: Inicia llamado a SWPedidosWWW, Comando a ejecutar: " + command1);
       // System.out.println(log);
       //  Cls_Log.insertaLog(connBD, log);          
        OutputStream inputstream_for_the_channel  = null;
        Channel channel= null;
        Session session = null;
        try{
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session=jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            //log.setAccion("wsPedidosWWW:Conectando con el servidor: " + host + "; User: " + user + "; Pass: "+ password + "; Port: 22.");
            //Cls_Log.insertaLog(connBD, log); 
            //System.out.println(log.getAccion());
            session.connect();

            if (session.isConnected())
            {
                /*log.setAccion("wsPedidosWWW:Conexion con el servidor Exitosa");
                Cls_Log.insertaLog(connBD, log); 
                System.out.println(log.getAccion());*/
            }
            else
            {
                /*log.setAccion("wsPedidosWWW:Conexion con el servidor NO exitosa");
                Cls_Log.insertaLog(connBD, log); 
                System.out.println(log.getAccion());*/
            }

            // log.setAccion("wsPedidosWWW: Abriendo Canal de comunicacion. ");

            channel=session.openChannel("shell");

 

          inputstream_for_the_channel = channel.getOutputStream();
          PrintStream commander = new PrintStream(inputstream_for_the_channel, true);

 

            channel.setOutputStream(System.out, true);

 

            // log.setAccion("wsPedidosWWW: Conectando Canal de comunicacion. ");
            //    Cls_Log.insertaLog(connBD, log); 
            //    System.out.println(log.getAccion());
            channel.connect();

 

            // log.setAccion("wsPedidosWWW: Ejecutando sentencias: " + command1);
            //    Cls_Log.insertaLog(connBD, log); 
            //    System.out.println(log.getAccion());
            commander.println("cd "+ruta); 
            commander.println("./crea_fact_4.sh "+serie+" "+folio+" "+impresora);
            commander.println("exit");
            commander.close();

 

        //    log.setAccion("wsPedidosWWW: Ternimna ejecucion sentencias: " + command1);
        //    Cls_Log.insertaLog(connBD, log); 
        //    System.out.println(log.getAccion());


            do {
                Thread.sleep(1000);
            } while(!channel.isEOF());

 

        //    log.setAccion("wsPedidosWWW: Desconectando canal");
        //    Cls_Log.insertaLog(connBD, log); 
        //    System.out.println(log.getAccion());

        //    log.setAccion("wsPedidosWWW: Desconectando session");
        //    Cls_Log.insertaLog(connBD, log); 
        //    System.out.println(log.getAccion());

            inputstream_for_the_channel.close();
            channel.disconnect();
            session.disconnect();

             rsp = String.valueOf(channel.getExitStatus());

        }catch(Exception e){

             rsp = String.valueOf(channel.getExitStatus());

            try {inputstream_for_the_channel.close();} catch (IOException e1) {}
            channel.disconnect();
            session.disconnect();


        //    InsertarLogAlamacen.insertarLog(new LogAlmacen(Integer.parseInt(ode), "Error catch interface facturacion. Error: ["+e.getMessage().toString().replace("'", "´")+"]. Usuario: "+empleado+". Ode: "+ode+". Pedido: "+pedido+"","t"), uname);
             System.out.println("AltaUsuariosCDO Enviar usuarios a MAyorista error: " +  e);
        //    log.setAccion("swPedidosWWW: Erro a ejecutar shell en sistema mayorista: " + e.toString().replace("'", "´"));
         //   Cls_Log.insertaLog(connBD,log);        
            e.printStackTrace();

        }
      return rsp;
    }
}
