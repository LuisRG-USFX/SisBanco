package example;


/**
* example/cotesHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/Usuari/Documents/NetBeansProjects/CorbaCotesInterface/src/cotes.idl
* lunes 29 de abril de 2019 00H13' BOT
*/

abstract public class cotesHelper
{
  private static String  _id = "IDL:example/cotes:1.0";

  public static void insert (org.omg.CORBA.Any a, example.cotes that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static example.cotes extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (example.cotesHelper.id (), "cotes");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static example.cotes read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_cotesStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, example.cotes value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static example.cotes narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof example.cotes)
      return (example.cotes)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      example._cotesStub stub = new example._cotesStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static example.cotes unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof example.cotes)
      return (example.cotes)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      example._cotesStub stub = new example._cotesStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}