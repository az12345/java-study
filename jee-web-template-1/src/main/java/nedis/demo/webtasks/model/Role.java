package nedis.demo.webtasks.model;

/**
 * @author nedis
 * @version 1.0
 */
public class Role extends AbstractModelBean {
	private static final long serialVersionUID = -5579993243608931120L;
	private Integer id;
	private String name;
	
	public Role() {
		super();
	}
	public Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object getIdModel() {
		return getId();
	}
}
