package br.nic.bgp.models;


public class BlocIP4Model {
	
	private String  _full_addr;
	private String[] _bloc;
	private int _prefix;
	private String _addr;
	private byte[] _mask;
	private byte[] _coded_add = new byte[4];
	
	public BlocIP4Model(String blc)
	{
		this._full_addr = blc;
		this._bloc = blc.split("/");
		_prefix = Integer.valueOf(_bloc[1]);
		_addr   = _bloc[0];
		this.setMask();
		this.encodeAddr();
	}
	
	
	private void setMask()
	{
			
		int temp = 0xffffffff << (32 - this._prefix);
		int value = temp;
	    this._mask = new byte[]{(byte)(value >>> 24), (byte)(value >> 16 & 0xff), (byte)(value >> 8 & 0xff), (byte)(value & 0xff) };
	    
	}
	
	private void encodeAddr()
	{
		String[] temp = this._addr.split("\\.");
		byte[] in_temp = new byte[4];
		
		in_temp[0] = (byte)(Integer.valueOf(temp[0]).byteValue());
		in_temp[1] = (byte)(Integer.valueOf(temp[1]).byteValue());
		in_temp[2] = (byte)(Integer.valueOf(temp[2]).byteValue());
		in_temp[3] = (byte)(Integer.valueOf(temp[3]).byteValue());
		
		this._coded_add[0] = (byte) (in_temp[0] & this._mask[0]);
		this._coded_add[1] = (byte) (in_temp[1] & this._mask[1]);
		this._coded_add[2] = (byte) (in_temp[2] & this._mask[2]);
		this._coded_add[3] = (byte) (in_temp[3] & this._mask[3]);
		
	}
	
	public boolean isFromBloc(String ip)
	{
		String[] temp = ip.split("\\.");
		byte[] in_temp = new byte[4];
		in_temp[0] = (byte)(Integer.valueOf(temp[0]).byteValue() & this._mask[0]);
		in_temp[1] = (byte)(Integer.valueOf(temp[1]).byteValue() & this._mask[1]);
		in_temp[2] = (byte)(Integer.valueOf(temp[2]).byteValue() & this._mask[2]);
		in_temp[3] = (byte)(Integer.valueOf(temp[3]).byteValue() & this._mask[3]);
		
		
		
		if(this._coded_add[0] != in_temp[0])
		{
			System.out.println("1");
			return false;
		}else{
			if(this._coded_add[1] != in_temp[1])
			{
				System.out.println("2");
				return false;
			}else{
				if(this._coded_add[2] != in_temp[2])
				{
					System.out.println("3");
					return false;
				}else{
					if(this._coded_add[3] != in_temp[3])
					{
						return false;
					}else{
						return true;
					}
				}
			}
		}
	}
	
	
	public String get_Full_Addr()
	{
		return this._full_addr;
	}
	

}
