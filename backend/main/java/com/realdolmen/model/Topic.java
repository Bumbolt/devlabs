package com.realdolmen.model;

import java.util.List;

public interface Topic {

    Long getId();

    String getTitle();

    String getDescription();

    List<DevLabsTag> getTags();

    List<DevLabsUser> getSubscribers();

    Session getSession();

}
