package com.realdolmen.model;

import java.util.Set;

public interface Topic extends DevlabsEntity {

    String getTitle();

    String getDescription();

    Set<DevLabsTag> getTags();

    Set<DevLabsUser> getSubscribers();

    Session getSession();

}
