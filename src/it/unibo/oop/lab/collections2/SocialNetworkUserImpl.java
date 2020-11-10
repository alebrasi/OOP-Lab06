package it.unibo.oop.lab.collections2;

import java.util.*;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {
	
    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
	
	private final Map<String, ArrayList<U>> circles;
	
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        circles = new HashMap<String, ArrayList<U>>();
    }
    
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
        circles = new HashMap<String, ArrayList<U>>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	boolean alreadyFriend = false;
    	
    	if(!circles.values().isEmpty()) {
	    	Collection<ArrayList<U>> s = circles.values();
	    	for(ArrayList<U> sa : s) {
	    		if(sa.contains(user)) {
	    			alreadyFriend = true;
	    		}
	    	}
    	}
    	
    	if(!circles.containsKey(circle)) {
    		circles.put(circle, new ArrayList<U>());
    	}
    	
    	circles.get(circle).add(user);
    	
    	return alreadyFriend;
    }
    
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	
    	Collection<U> tmp = circles.get(groupName);
    	
    	if(tmp == null) {
    		return new ArrayList<U>();
    	}
        return new ArrayList<U>(tmp);
    }

    @Override
    public List<U> getFollowedUsers() {
        List<U> tmp = new ArrayList<U>();
        
        for (List<U> u : circles.values()) {
			tmp.addAll(u);
		}
        return tmp;
    }

}
