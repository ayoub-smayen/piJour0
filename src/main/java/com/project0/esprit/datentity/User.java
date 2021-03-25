package com.project0.esprit.datentity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.project0.esprit.entity.Cart0;
import com.project0.esprit.entity.Orders0;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="uservote")
public   class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;
    
    @Column(unique=true)
    @Email
    private String email;
    //password is only passed when deseralization is happening - input request
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private boolean disabled;
    
    
    public User(Long id, String username, @Email String email, String password, boolean disabled, Lprofile lprofile,
			List<Role> roles, List<Poll> polls, List<Publication> publications, List<Comment> comments,
			List<Comments> pcomments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.lprofile = lprofile;
		this.roles = roles;
		this.polls = polls;
		this.publications = publications;
		this.comments = comments;
		this.pcomments = pcomments;
	}

	public User(String username, @Email String email, String password, boolean disabled, Lprofile lprofile,
			List<Role> roles, List<Poll> polls, List<Publication> publications, List<Comment> comments,
			List<Comments> pcomments) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.lprofile = lprofile;
		this.roles = roles;
		this.polls = polls;
		this.publications = publications;
		this.comments = comments;
		this.pcomments = pcomments;
	}

	//@JsonIgnore
	@Embedded
    private Lprofile lprofile;
    
    
    /*public Myprofile getMyprofile() {
		return myprofile;
	}

	public void setMyprofile(Myprofile myprofile) {
		this.myprofile = myprofile;
	}
	@JsonIgnore
	@OneToOne(mappedBy = "user",optional = true)
	//@PrimaryKeyJoinColumn
    private Myprofile  myprofile;
   */ 

    public Lprofile getLprofile() {
		return lprofile;
	}

	

	public User(String username, @Email String email, String password, boolean disabled, List<Role> roles,
			List<Poll> polls, List<Orders0> orders0, List<Cart0> carts0, List<Publication> publications,
			List<Comment> comments, List<Comments> pcomments) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.roles = roles;
		this.polls = polls;
		this.orders0 = orders0;
		this.carts0 = carts0;
		this.publications = publications;
		this.comments = comments;
		this.pcomments = pcomments;
	}

	public void setLprofile(Lprofile lprofile) {
		this.lprofile = lprofile;
	}

	public List<Comments> getPcomments() {
		return pcomments;
	}

	public void setPcomments(List<Comments> pcomments) {
		this.pcomments = pcomments;
	}

	public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.disabled = false;
    }

    public User(String username, @Email String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
        this.disabled = false;
	}

	public String getEmail() {
		return email;
	}

	public User(Long id, String username, @Email String email, String password, boolean disabled, List<Role> roles,
			List<Poll> polls) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.roles = roles;
		this.polls = polls;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
    }

    @ManyToMany
//    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Poll> polls;
   // @JsonManagedReference
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Orders0> orders0 ;
    
    public List<Orders0> getOrders0() {
		return orders0;
	}

	public User(Long id, String username, @Email String email, String password, boolean disabled, Lprofile lprofile,
			List<Role> roles, List<Poll> polls, List<Orders0> orders0, List<Cart0> carts0,
			List<Publication> publications, List<Comment> comments, List<Comments> pcomments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.lprofile = lprofile;
		this.roles = roles;
		this.polls = polls;
		this.orders0 = orders0;
		this.carts0 = carts0;
		this.publications = publications;
		this.comments = comments;
		this.pcomments = pcomments;
	}

	public User(String username, @Email String email, String password, boolean disabled, Lprofile lprofile,
			List<Role> roles, List<Poll> polls, List<Orders0> orders0, List<Cart0> carts0,
			List<Publication> publications, List<Comment> comments, List<Comments> pcomments) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.lprofile = lprofile;
		this.roles = roles;
		this.polls = polls;
		this.orders0 = orders0;
		this.carts0 = carts0;
		this.publications = publications;
		this.comments = comments;
		this.pcomments = pcomments;
	}

	public void setOrders0(List<Orders0> orders0) {
		this.orders0 = orders0;
	}

	public List<Cart0> getCarts0() {
		return carts0;
	}

	public void setCarts0(List<Cart0> carts0) {
		this.carts0 = carts0;
	}

	//@JsonManagedReference
	@JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Cart0> carts0 ;
    
    public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public User(Long id, String username, @Email String email, String password, boolean disabled, List<Role> roles,
			List<Poll> polls, List<Publication> publications, List<Comment> comments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.roles = roles;
		this.polls = polls;
		this.publications = publications;
		this.comments = comments;
	}

	public User(String username, @Email String email, String password, boolean disabled, List<Role> roles,
			List<Poll> polls, List<Publication> publications, List<Comment> comments) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.roles = roles;
		this.polls = polls;
		this.publications = publications;
		this.comments = comments;
	}
	
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user2")
    @JsonIgnore
    private List<Publication> publications;

    
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "user1")
    private List<Comment> comments ;
    
    // @JsonManagedReference
    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "user")
    private List<Comments> pcomments ;
    
    public List<Comment> getComments() {
		return comments;
	}

	public User(Long id, String username, @Email String email, String password, boolean disabled, List<Role> roles,
			List<Poll> polls, List<Comment> comments) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.roles = roles;
		this.polls = polls;
		this.comments = comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }
/*
    public User(Long id, String username, @Email String email, String password, boolean disabled, Myprofile myprofile,
			List<Role> roles, List<Poll> polls) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.disabled = disabled;
		this.myprofile = myprofile;
		this.roles = roles;
		this.polls = polls;
	}
*/
	public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (Role r : roles) {
            authorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return r.getRole();
                }

                @Override
                public String toString() {
                    return r.getRole();
                }

            });

        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", disabled=" + disabled + ", roles=" + roles + ", polls=" + polls + '}';
    }
}
