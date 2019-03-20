package com.stackroute.ExternalDb.service;

import com.stackroute.ExternalDb.domain.Items;

import java.util.List;

public interface APIservice {


   public List<Items> getData(String url);
}
