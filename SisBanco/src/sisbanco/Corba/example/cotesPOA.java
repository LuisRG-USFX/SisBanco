package example;


/**
* example/cotesPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Usuari/Documents/NetBeansProjects/CorbaCotesInterface/src/cotes.idl
* lunes 29 de abril de 2019 00H13' BOT
*/

public abstract class cotesPOA extends org.omg.PortableServer.Servant
 implements example.cotesOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("pedientes", new java.lang.Integer (0));
    _methods.put ("pagar", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // example/cotes/pedientes
       {
         int idcliente = in.read_long ();
         String $result = null;
         $result = this.pedientes (idcliente);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // example/cotes/pagar
       {
         String facturas = in.read_string ();
         String $result = null;
         $result = this.pagar (facturas);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:example/cotes:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public cotes _this() 
  {
    return cotesHelper.narrow(
    super._this_object());
  }

  public cotes _this(org.omg.CORBA.ORB orb) 
  {
    return cotesHelper.narrow(
    super._this_object(orb));
  }


} // class cotesPOA
