package com.realdolmen.model;

import java.util.List;

public interface Topic extends DevlabsEntity {

    String getTitle();

    String getDescription();

    List<DevLabsTag> getTags();

    List<DevLabsUser> getSubscribers();

    Session getSession();

}
