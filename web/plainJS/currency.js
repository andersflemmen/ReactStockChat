function createStockElement(stock){
  var name = stock.name;
  var price = stock.price;
  var volume = stock.colume;
  var type = stock.type;
  var day_high = stock.day_high;
  var day_low = stock.day_low;
  var year_high = stock.year_high;
  var year_low = stock.year_low;
  var chg_percent = stock.chg_percent;
  var change = stock.change;

  var date = (new Date(stock.utctime)).toLocaleString();

  var mainDiv = document.createElement("DIV");
  mainDiv.className = "panel panel-info pull-left stockPanel"
  var headerDiv = document.createElement("DIV");
  headerDiv.className = "panel-heading";
  var bodyDiv = document.createElement("DIV");
  bodyDiv = "panel-body";

  //heading
  var heading = document.createElement("H3");
  heading.className = "panel-title";
  var stockName = document.createElement("B");
  stockName.innerHTML = "{name}";
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
  priceLi.innerHTML = "{price}";

  var symbolLi = document.createElement("LI");
  symbolLi.className = "list-group-item";
  symbolLi.innerHTML = "{symbol}";

  var volumeLi = document.createElement("LI");
  volumeLi.className = "list-group-item";
  volumeLi.innerHTML = "{volume}";

  var typeLi = document.createElement("LI");
  typeLi.className = "list-group-item";
  typeLi.innerHTML = "{type}";

  var changeLi = document.createElement("LI");
  //priceLi.className = "list-group-item";
  changeLi.innerHTML = "{chg_percent}";

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
  dayHighLi.innerHTML = "Day High: {day_high}";

  var dayLowLi = document.createElement("LI");
  dayLowLi.className = "list-group-item list-group-item list-group-item-success";
  dayLowLi.innerHTML = "Day Low: {day_low}";

  var yearHighLi = document.createElement("LI");
  yearHighLi.className = "list-group-item list-group-item list-group-item-success";
  yearHighLi.innerHTML = "Year High: {day_high}";

  var yearLowLi = document.createElement("LI");
  yearLowLi.className = "list-group-item list-group-item list-group-item-success";
  yearLowLi.innerHTML = "Year low: {day_high}";

  var change2Li = document.createElement("LI");
  change2Li.className = "list-group-item list-group-item list-group-item-success";
  change2Li.innerHTML = "Change: {day_high}";

  secondTdUl.appendChild(dayHighLi);
  secondTdUl.appendChild(dayLowLi);
  secondTdUl.appendChild(yearHighLi);
  secondTdUl.appendChild(yearLowLi);
  secondTdUl.appendChild(change2Li);

  secondTdDIV.appendChild(secondTdUl);
  secondTD.appendChild(secondTdDIV);

  var lastUpdate = document.createElement("P");
  var lastUpdateB = document.createElement("B");
  lastUpdateB.innerHTML = "Last update:  + {date}";

  lastUpdate.appendChild(lastUpdateB);

  table.appendChild(firstTd);
  table.appendChild(secondTD);

  bodyDiv.appendChild(table);
  bodyDiv.appendChild(lastUpdate);

  mainDiv.appendChild(headerDiv);
  mainDiv.appendChild(bodyDiv);

 return mainDiv;
};
