package com.durasoft.client;

import java.util.ArrayList;
import java.util.List;

import com.durasoft.client.model.Country;
import com.durasoft.client.model.CountryProperties;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class SampleEntryPoint implements EntryPoint {

	private CountryProperties countryProps = GWT.create(CountryProperties.class);
	@Override
	public void onModuleLoad() {
		ColumnModel<Country> colModel = new ColumnModel<Country>(getColumns());
		Grid<Country> countryGrid = new Grid<Country>(getCountryStore(), colModel);
		countryGrid.setWidth(200);
		RootPanel.get().add(countryGrid);
	}

	private List<ColumnConfig<Country, ?>> getColumns(){
		ColumnConfig<Country, String> nameCol = new ColumnConfig<Country, String>(countryProps.name(),100,"Name");
		ColumnConfig<Country, String> capitalCol = new ColumnConfig<Country, String>(countryProps.capital(),100,"Capital");
		
		List<ColumnConfig<Country, ?>> columnsList = new ArrayList<ColumnConfig<Country,?>>();
		columnsList.add(nameCol);
		columnsList.add(capitalCol);
		return columnsList;
	}
	
	private ListStore<Country> getCountryStore(){
		ListStore<Country> countryStore = new ListStore<Country>(countryProps.key());
		countryStore.add(new Country("India", "New Delhi"));
		countryStore.add(new Country("USA", "Washington, D.C"));
		countryStore.add(new Country("UK", "London"));
		return countryStore;
	}
}
