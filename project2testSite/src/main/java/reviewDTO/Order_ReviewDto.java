package reviewDTO;

public class Order_ReviewDto {
	private int oi_no;
	private int r_no;
	
	public Order_ReviewDto() {
		// TODO Auto-generated constructor stub
	}

	public Order_ReviewDto(int oi_no, int r_no) {
		super();
		this.oi_no = oi_no;
		this.r_no = r_no;
	}

	public int getOi_no() {
		return oi_no;
	}

	public void setOi_no(int oi_no) {
		this.oi_no = oi_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	@Override
	public String toString() {
		return "Order_ReviewDto [oi_no=" + oi_no + ", r_no=" + r_no + "]";
	}

	
	

}
