package com.country.model;

import java.io.Serializable;

public class StateId implements Serializable {
    private String country_cd;

    private String state_cd;

    public StateId() {
        
    }

    public StateId(String country_cd, String state_cd) {
        this.country_cd = country_cd;
        this.state_cd = state_cd;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country_cd == null) ? 0 : country_cd.hashCode());
        result = prime * result + ((state_cd == null) ? 0 : state_cd.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StateId other = (StateId) obj;
        if (country_cd == null) {
            if (other.country_cd != null)
                return false;
        } else if (!country_cd.equals(other.country_cd))
            return false;
        if (state_cd == null) {
            if (other.state_cd != null)
                return false;
        } else if (!state_cd.equals(other.state_cd))
            return false;
        return true;
       }
}
