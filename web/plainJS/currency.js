function createStockElement(stock,place){

  var name = stock.name;
  var price = stock.price;
  var symbol = stock.symbol;
  var volume = stock.volume;
  var type = stock.type;
  var day_high = stock.day_high;
  var day_low = stock.day_low;
  var year_high = stock.year_high;
  var year_low = stock.year_low;
  var chg_percent = stock.chg_percent;
  var change = stock.change;

  var date = (new Date(stock.utctime)).toLocaleString();

  var mainDiv = document.createElement("DIV");
  mainDiv.className = "panel panel-info pull-left stockPanel";
  var headerDiv = document.createElement("DIV");
  headerDiv.className = "panel-heading";
  var bodyDiv = document.createElement("DIV");
  bodyDiv.className = "panel-body";

  //heading
  var heading = document.createElement("H3");
  heading.className = "panel-title";
  var stockName = document.createElement("B");
  stockName.innerHTML = name;
  heading.appendChild(stockName);
  headerDiv.appendChild(heading);

  //body
  var table = document.createElement("TABLE");
  table.className = "stockPanelTable";
  var col1 = document.createElement("COL");
  var col2 = document.createElement("COL");
  col1.style.width = "50%";
  col2.style.width = "50%";
  table.appendChild(col1);
  table.appendChild(col2);

  //table
  var firstTd = document.createElement("TD");
  var firstTdDIV = document.createElement("DIV");
  var firstTdUl = document.createElement("UL");
  firstTdUl.className = "list-group";

  var priceLi = document.createElement("LI");
  priceLi.className = "list-group-item";
  priceLi.innerHTML = ("Price: ").bold() +price;

  var symbolLi = document.createElement("LI");
  symbolLi.className = "list-group-item";
  symbolLi.innerHTML = "Symbol: ".bold() + symbol;

  var volumeLi = document.createElement("LI");
  volumeLi.className = "list-group-item";
  volumeLi.innerHTML = "Volume:".bold() +volume;

  var typeLi = document.createElement("LI");
  typeLi.className = "list-group-item";
  typeLi.innerHTML = "Type: ".bold() + type;

  var changeLi = document.createElement("LI");

  changeLi.className = chg_percent > 0 ? "list-group-item list-group-item-success" : chg_percent < 0 ? "list-group-item list-group-item-danger" : "list-group-item list-group-item-warning" ;
  changeLi.innerHTML = "Change in %: ".bold() + chg_percent;

  firstTdUl.appendChild(priceLi);
  firstTdUl.appendChild(symbolLi);
  firstTdUl.appendChild(volumeLi);
  firstTdUl.appendChild(typeLi);
  firstTdUl.appendChild(changeLi);
  firstTdDIV.appendChild(firstTdUl);
  firstTd.appendChild(firstTdDIV);

  var secondTD = document.createElement("TD");
  var secondTdDIV = document.createElement("DIV");
  var secondTdUl = document.createElement("UL");
  secondTdUl.className = "list-group";

  var dayHighLi = document.createElement("LI");
  dayHighLi.className = "list-group-item list-group-item list-group-item-success";
  dayHighLi.innerHTML = "Day High: ".bold() + day_high;

  var dayLowLi = document.createElement("LI");
  dayLowLi.className = "list-group-item list-group-item list-group-item-danger";
  dayLowLi.innerHTML = "Day Low: ".bold() + day_low;

  var yearHighLi = document.createElement("LI");
  yearHighLi.className = "list-group-item list-group-item list-group-item-success";
  yearHighLi.innerHTML = "Year High: ".bold() + year_high;

  var yearLowLi = document.createElement("LI");
  yearLowLi.className = "list-group-item list-group-item list-group-item-danger";
  yearLowLi.innerHTML = "Year low: ".bold() + year_low;

  var change2Li = document.createElement("LI");
  change2Li.className = change > 0 ? "list-group-item list-group-item-success" : change < 0 ? "list-group-item list-group-item-danger" : "list-group-item list-group-item-warning" ;
  change2Li.innerHTML = "Change: ".bold() + change;

  secondTdUl.appendChild(dayHighLi);
  secondTdUl.appendChild(dayLowLi);
  secondTdUl.appendChild(yearHighLi);
  secondTdUl.appendChild(yearLowLi);
  secondTdUl.appendChild(change2Li);

  secondTdDIV.appendChild(secondTdUl);
  secondTD.appendChild(secondTdDIV);

  var lastUpdate = document.createElement("P");
  var lastUpdateB = document.createElement("B");
  lastUpdateB.innerHTML = "Last update: ".bold() + date;

  lastUpdate.appendChild(lastUpdateB);

  table.appendChild(firstTd);
  table.appendChild(secondTD);

  bodyDiv.appendChild(table);
  bodyDiv.appendChild(lastUpdate);

  mainDiv.appendChild(headerDiv);
  mainDiv.appendChild(bodyDiv);
  var pagePlace = document.getElementById(place);
  pagePlace.appendChild(mainDiv);

};

function createStockHTML(place){

  var mainDiv = document.createElement("DIV");

  mainDiv.className = "panel panel-info pull-left stockPanel";
  mainDiv.id = "mainDiv";
  var headerDiv = document.createElement("DIV");
  headerDiv.className = "panel-heading";
  var bodyDiv = document.createElement("DIV");
  bodyDiv.className = "panel-body";

  //heading
  var heading = document.createElement("H3");
  heading.className = "panel-title";
  var stockName = document.createElement("B");
  stockName.id = "name";
  heading.appendChild(stockName);
  headerDiv.appendChild(heading);

  //body
  var table = document.createElement("TABLE");
  table.className = "stockPanelTable";
  var col1 = document.createElement("COL");
  var col2 = document.createElement("COL");
  col1.style.width = "50%";
  col2.style.width = "50%";
  table.appendChild(col1);
  table.appendChild(col2);

  //table
  var firstTd = document.createElement("TD");
  var firstTdDIV = document.createElement("DIV");
  var firstTdUl = document.createElement("UL");
  firstTdUl.className = "list-group";

  var priceLi = document.createElement("LI");
  priceLi.className = "list-group-item";
  priceLi.id = "price";

  var symbolLi = document.createElement("LI");
  symbolLi.className = "list-group-item";
  symbolLi.id = "symbol";

  var volumeLi = document.createElement("LI");
  volumeLi.className = "list-group-item";
  volumeLi.id ="volume";

  var typeLi = document.createElement("LI");
  typeLi.className = "list-group-item";
  typeLi.id = "type";

  var changeLi = document.createElement("LI");
  changeLi.className = "list-group-item list-group-item-warning" ;
  changeLi.id = "chg_percent";

  firstTdUl.appendChild(priceLi);
  firstTdUl.appendChild(symbolLi);
  firstTdUl.appendChild(volumeLi);
  firstTdUl.appendChild(typeLi);
  firstTdUl.appendChild(changeLi);
  firstTdDIV.appendChild(firstTdUl);
  firstTd.appendChild(firstTdDIV);

  var secondTD = document.createElement("TD");
  var secondTdDIV = document.createElement("DIV");
  var secondTdUl = document.createElement("UL");
  secondTdUl.className = "list-group";

  var dayHighLi = document.createElement("LI");
  dayHighLi.className = "list-group-item list-group-item list-group-item-success";
  dayHighLi.id = "day_high";

  var dayLowLi = document.createElement("LI");
  dayLowLi.className = "list-group-item list-group-item list-group-item-danger";
  dayLowLi.id = "day_low";

  var yearHighLi = document.createElement("LI");
  yearHighLi.className = "list-group-item list-group-item list-group-item-success";
  yearHighLi.id = "year_high";

  var yearLowLi = document.createElement("LI");
  yearLowLi.className = "list-group-item list-group-item list-group-item-danger";
  yearLowLi.id = "year_low";

  var change2Li = document.createElement("LI");
  change2Li.className = "list-group-item list-group-item-warning" ;
  change2Li.id = "change";

  secondTdUl.appendChild(dayHighLi);
  secondTdUl.appendChild(dayLowLi);
  secondTdUl.appendChild(yearHighLi);
  secondTdUl.appendChild(yearLowLi);
  secondTdUl.appendChild(change2Li);

  secondTdDIV.appendChild(secondTdUl);
  secondTD.appendChild(secondTdDIV);

  var lastUpdate = document.createElement("P");
  var lastUpdateB = document.createElement("B");
  lastUpdateB.id = "lastUpdateB";

  lastUpdate.appendChild(lastUpdateB);

  table.appendChild(firstTd);
  table.appendChild(secondTD);

  bodyDiv.appendChild(table);
  bodyDiv.appendChild(lastUpdate);

  mainDiv.appendChild(headerDiv);
  mainDiv.appendChild(bodyDiv);
  var pagePlace = document.getElementById(place);
  pagePlace.appendChild(mainDiv);

};

function updateSingleStock(url){
  $.ajax({
    url: url,
    dataType: 'json',
    cache: false,
    success: function(data) {
        updateValues(data.resources[0]);
    }.bind(this),
    error: function(xhr, status, err) {
      console.error(status, err.toString());
    }
  })

};

function createStocks(stocks,single,place){
  if(single === true){
    createStockElement(stocks[0],place);
  }
  else{
    stocks.map(function (stock){
    createStockElement(stock, place);
  }
);
}
}

function updateValues(stock){

  var name = stock.name;
  var price = stock.price;
  var symbol = stock.symbol;
  var volume = stock.volume;
  var type = stock.type;
  var day_high = stock.day_high;
  var day_low = stock.day_low;
  var year_high = stock.year_high;
  var year_low = stock.year_low;
  var chg_percent = stock.chg_percent;
  var change = stock.change;

  var date = (new Date(stock.utctime)).toLocaleString();

  var stockName = document.getElementById("name");
  stockName.innerHTML = name;

  var priceLi = document.getElementById("price");
  priceLi.innerHTML = ("Price: ").bold() + price;

  var symbolLi = document.getElementById("symbol");
  symbolLi.innerHTML = symbolLi.innerHTML = "Symbol: ".bold() + symbol;

  var volumeLi = document.getElementById("volume");
  volumeLi.innerHTML = "Volume: ".bold() +volume;

  var typeLi = document.getElementById("type");
  typeLi.innerHTML = "Type: ".bold() + type;

  var dayHighLi = document.getElementById("day_high");
  dayHighLi.innerHTML = "Day High: ".bold() + day_high;

  var dayLowLi = document.getElementById("day_low");
  dayLowLi.innerHTML = "Day Low: ".bold() + day_low;

  var yearHighLi = document.getElementById("year_high");
  yearHighLi.innerHTML = "Year High: ".bold() + year_high;

  var yearLowLi = document.getElementById("year_low");
  yearLowLi.innerHTML = "Year low: ".bold() + year_low;

  var changeLi = document.getElementById("chg_percent");
  changeLi.className = chg_percent > 0 ? "list-group-item list-group-item-success" : chg_percent < 0 ? "list-group-item list-group-item-danger" : "list-group-item list-group-item-warning" ;
  changeLi.innerHTML = "Change in %: ".bold() + chg_percent;

  var change2Li = document.getElementById("change");
  change2Li.innerHTML = "Change: ".bold() + change;

  lastUpdateB = document.getElementById("lastUpdateB");
  change2Li.className = change > 0 ? "list-group-item list-group-item-success" : change < 0 ? "list-group-item list-group-item-danger" : "list-group-item list-group-item-warning" ;
  lastUpdateB.innerHTML = "Last update: ".bold() + date;

}

function loadCurrenciesFromServer(url, single,place){

  $.ajax({
    url: url,
    dataType: 'json',
    cache: false,
    success: function(data) {
        createStocks(data.resources,single,place);
    }.bind(this),
    error: function(xhr, status, err) {
      console.error(status, err.toString());
    }
  })

};

function updateSingleStock(url){
  $.ajax({
    url: url,
    dataType: 'json',
    cache: false,
    success: function(data) {
        updateValues(data.resources[0]);
    }.bind(this),
    error: function(xhr, status, err) {
      console.error(status, err.toString());
    }
  })

};
