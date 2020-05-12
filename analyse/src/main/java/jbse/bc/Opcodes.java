package jbse.bc;

/**
 * Constants for opcodes.
 * 
 * @author Pietro Braione
 * @author unknown
 *
 */
public final class Opcodes {
    //defined by the JVM specs
	public static final byte OP_NOP = 0;
	public static final byte OP_ACONST_NULL = 1;
	public static final byte OP_ICONST_M1 = 2;
	public static final byte OP_ICONST_0 = 3;
	public static final byte OP_ICONST_1 = 4;
	public static final byte OP_ICONST_2 = 5;
	public static final byte OP_ICONST_3 = 6;
	public static final byte OP_ICONST_4 = 7;
	public static final byte OP_ICONST_5 = 8;
	public static final byte OP_LCONST_0 = 9;
	public static final byte OP_LCONST_1 = 10;
	public static final byte OP_FCONST_0 = 11;
	public static final byte OP_FCONST_1 = 12;
	public static final byte OP_FCONST_2 = 13;
	public static final byte OP_DCONST_0 = 14;
	public static final byte OP_DCONST_1 = 15;
	public static final byte OP_BIPUSH = 16;
	public static final byte OP_SIPUSH = 17;
	public static final byte OP_LDC = 18;
	public static final byte OP_LDC_W = 19;
	public static final byte OP_LDC2_W = 20;
	public static final byte OP_ILOAD = 21;
	public static final byte OP_LLOAD = 22;
	public static final byte OP_FLOAD = 23;
	public static final byte OP_DLOAD = 24;
	public static final byte OP_ALOAD = 25;
	public static final byte OP_ILOAD_0 = 26;
	public static final byte OP_ILOAD_1 = 27;
	public static final byte OP_ILOAD_2 = 28;
	public static final byte OP_ILOAD_3 = 29;
	public static final byte OP_LLOAD_0 = 30;
	public static final byte OP_LLOAD_1 = 31;
	public static final byte OP_LLOAD_2 = 32;
	public static final byte OP_LLOAD_3 = 33;
	public static final byte OP_FLOAD_0 = 34;
	public static final byte OP_FLOAD_1 = 35;
	public static final byte OP_FLOAD_2 = 36;
	public static final byte OP_FLOAD_3 = 37;
	public static final byte OP_DLOAD_0 = 38;
	public static final byte OP_DLOAD_1 = 39;
	public static final byte OP_DLOAD_2 = 40;
	public static final byte OP_DLOAD_3 = 41;
	public static final byte OP_ALOAD_0 = 42;
	public static final byte OP_ALOAD_1 = 43;
	public static final byte OP_ALOAD_2 = 44;
	public static final byte OP_ALOAD_3 = 45;
	public static final byte OP_IALOAD = 46;
	public static final byte OP_LALOAD = 47;
	public static final byte OP_FALOAD = 48;
	public static final byte OP_DALOAD = 49;
	public static final byte OP_AALOAD = 50;
	public static final byte OP_BALOAD = 51;
	public static final byte OP_CALOAD = 52;
	public static final byte OP_SALOAD = 53;
	public static final byte OP_ISTORE = 54;
	public static final byte OP_LSTORE = 55;
	public static final byte OP_FSTORE = 56;
	public static final byte OP_DSTORE = 57;
	public static final byte OP_ASTORE = 58;
	public static final byte OP_ISTORE_0 = 59;
	public static final byte OP_ISTORE_1 = 60;
	public static final byte OP_ISTORE_2 = 61;
	public static final byte OP_ISTORE_3 = 62;
	public static final byte OP_LSTORE_0 = 63;
	public static final byte OP_LSTORE_1 = 64;
	public static final byte OP_LSTORE_2 = 65;
	public static final byte OP_LSTORE_3 = 66;
	public static final byte OP_FSTORE_0 = 67;
	public static final byte OP_FSTORE_1 = 68;
	public static final byte OP_FSTORE_2 = 69;
	public static final byte OP_FSTORE_3 = 70;
	public static final byte OP_DSTORE_0 = 71;
	public static final byte OP_DSTORE_1 = 72;
	public static final byte OP_DSTORE_2 = 73;
	public static final byte OP_DSTORE_3 = 74;
	public static final byte OP_ASTORE_0 = 75;
	public static final byte OP_ASTORE_1 = 76;
	public static final byte OP_ASTORE_2 = 77;
	public static final byte OP_ASTORE_3 = 78;
	public static final byte OP_IASTORE = 79;
	public static final byte OP_LASTORE = 80;
	public static final byte OP_FASTORE = 81;
	public static final byte OP_DASTORE = 82;
	public static final byte OP_AASTORE = 83;
	public static final byte OP_BASTORE = 84;
	public static final byte OP_CASTORE = 85;
	public static final byte OP_SASTORE = 86;
	public static final byte OP_POP = 87;
	public static final byte OP_POP2 = 88;
	public static final byte OP_DUP = 89;
	public static final byte OP_DUP_X1 = 90;
	public static final byte OP_DUP_X2 = 91;
	public static final byte OP_DUP2 = 92;
	public static final byte OP_DUP2_X1 = 93;
	public static final byte OP_DUP2_X2 = 94;
	public static final byte OP_SWAP = 95;
	public static final byte OP_IADD = 96;
	public static final byte OP_LADD = 97;
	public static final byte OP_FADD = 98;
	public static final byte OP_DADD = 99;
	public static final byte OP_ISUB = 100;
	public static final byte OP_LSUB = 101;
	public static final byte OP_FSUB = 102;
	public static final byte OP_DSUB = 103;
	public static final byte OP_IMUL = 104;
	public static final byte OP_LMUL = 105;
	public static final byte OP_FMUL = 106;
	public static final byte OP_DMUL = 107;
	public static final byte OP_IDIV = 108;
	public static final byte OP_LDIV = 109;
	public static final byte OP_FDIV = 110;
	public static final byte OP_DDIV = 111;
	public static final byte OP_IREM = 112;
	public static final byte OP_LREM = 113;
	public static final byte OP_FREM = 114;
	public static final byte OP_DREM = 115;
	public static final byte OP_INEG = 116;
	public static final byte OP_LNEG = 117;
	public static final byte OP_FNEG = 118;
	public static final byte OP_DNEG = 119;
	public static final byte OP_ISHL = 120;
	public static final byte OP_LSHL = 121;
	public static final byte OP_ISHR = 122;
	public static final byte OP_LSHR = 123;
	public static final byte OP_IUSHR = 124;
	public static final byte OP_LUSHR = 125;
	public static final byte OP_IAND = 126;
	public static final byte OP_LAND = 127;
	public static final byte OP_IOR = -128;
	public static final byte OP_LOR = -127;
	public static final byte OP_IXOR = -126;
	public static final byte OP_LXOR = -125;
	public static final byte OP_IINC = -124;
	public static final byte OP_I2L = -123;
	public static final byte OP_I2F = -122;
	public static final byte OP_I2D = -121;
	public static final byte OP_L2I = -120;
	public static final byte OP_L2F = -119;
	public static final byte OP_L2D = -118;
	public static final byte OP_F2I = -117;
	public static final byte OP_F2L = -116;
	public static final byte OP_F2D = -115;
	public static final byte OP_D2I = -114;
	public static final byte OP_D2L = -113;
	public static final byte OP_D2F = -112;
	public static final byte OP_I2B = -111;
	public static final byte OP_I2C = -110;
	public static final byte OP_I2S = -109;
	public static final byte OP_LCMP = -108;
	public static final byte OP_FCMPL = -107;
	public static final byte OP_FCMPG = -106;
	public static final byte OP_DCMPL = -105;
	public static final byte OP_DCMPG = -104;
	public static final byte OP_IFEQ = -103;
	public static final byte OP_IFNE = -102;
	public static final byte OP_IFLT = -101;
	public static final byte OP_IFGE = -100;
	public static final byte OP_IFGT = -99;
	public static final byte OP_IFLE = -98;
	public static final byte OP_IF_ICMPEQ = -97;
	public static final byte OP_IF_ICMPNE = -96;
	public static final byte OP_IF_ICMPLT = -95;
	public static final byte OP_IF_ICMPGE = -94;
	public static final byte OP_IF_ICMPGT = -93;
	public static final byte OP_IF_ICMPLE = -92;
	public static final byte OP_IF_ACMPEQ = -91;
	public static final byte OP_IF_ACMPNE = -90;
	public static final byte OP_GOTO = -89;
	public static final byte OP_JSR = -88;
	public static final byte OP_RET = -87;
	public static final byte OP_TABLESWITCH = -86;
	public static final byte OP_LOOKUPSWITCH = -85;
	public static final byte OP_IRETURN = -84;
	public static final byte OP_LRETURN = -83;
	public static final byte OP_FRETURN = -82;
	public static final byte OP_DRETURN = -81;
	public static final byte OP_ARETURN = -80;
	public static final byte OP_RETURN = -79;
	public static final byte OP_GETSTATIC = -78;
	public static final byte OP_PUTSTATIC = -77;
	public static final byte OP_GETFIELD = -76;
	public static final byte OP_PUTFIELD = -75;
	public static final byte OP_INVOKEVIRTUAL = -74;
	public static final byte OP_INVOKESPECIAL = -73;
	public static final byte OP_INVOKESTATIC = -72;
	public static final byte OP_INVOKEINTERFACE = -71;
	public static final byte OP_INVOKEDYNAMIC = -70;
	public static final byte OP_NEW = -69;
	public static final byte OP_NEWARRAY = -68;
	public static final byte OP_ANEWARRAY = -67;
	public static final byte OP_ARRAYLENGTH = -66;
	public static final byte OP_ATHROW = -65;
	public static final byte OP_CHECKCAST = -64;
	public static final byte OP_INSTANCEOF = -63;
	public static final byte OP_MONITORENTER = -62;
	public static final byte OP_MONITOREXIT = -61;
	public static final byte OP_WIDE = -60;
	public static final byte OP_MULTIANEWARRAY = -59;
	public static final byte OP_IFNULL = -58;
	public static final byte OP_IFNONNULL = -57;
	public static final byte OP_GOTO_W = -56;
	public static final byte OP_JSR_W = -55;
	public static final byte OP_BREAKPOINT = -54;
	
	//internally used in java v.1
	public static final byte OP_LDC_QUICK = -53;
	public static final byte OP_LDC_W_QUICK = -52;
	public static final byte OP_LDC2_W_QUICK = -51;
	public static final byte OP_GETFIELD_QUICK = -50;
	public static final byte OP_PUTFIELD_QUICK = -49;
	public static final byte OP_GETFIELD2_QUICK = -48;
	public static final byte OP_PUTFIELD2_QUICK = -47;
	public static final byte OP_GETSTATIC_QUICK = -46;
	public static final byte OP_PUTSTATIC_QUICK = -45;
	public static final byte OP_GETSTATIC2_QUICK = -44;
	public static final byte OP_PUTSTATIC2_QUICK = -43;
	public static final byte OP_INVOKEVIRTUAL_QUICK = -42;
	public static final byte OP_INVOKENONVIRTUAL_QUICK = -41;
	public static final byte OP_INVOKESUPER_QUICK = -40;
	public static final byte OP_INVOKESTATIC_QUICK = -39;
	public static final byte OP_INVOKEINTERFACE_QUICK = -38;
	public static final byte OP_INVOKEVIRTUALOBJECT_QUICK = -37;
	public static final byte OP_NEW_QUICK = -35;
	public static final byte OP_ANEWARRAY_QUICK = -34;
	public static final byte OP_MULTIANEWARRAY_QUICK = -33;
	public static final byte OP_CHECKCAST_QUICK = -32;
	public static final byte OP_INSTANCEOF_QUICK = -31;
	public static final byte OP_INVOKEVIRTUAL_QUICK_W = -30;
	public static final byte OP_GETFIELD_QUICK_W = -29;
	public static final byte OP_PUTFIELD_QUICK_W = -28;

	//implementation-dependent
	public static final byte OP_IMPDEP1 = -2;
	public static final byte OP_IMPDEP2 = -1;
	
	/**
	 * Do not instantiate it!
	 */
	private Opcodes() { }
}
