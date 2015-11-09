var MyNavbarInstance = React.createClass ({
  render: function() {

    var Navbar = ReactBootstrap.Navbar,
    NavBrand = ReactBootstrap.NavBrand,
    NavDropdown = ReactBootstrap.NavDropdown,
    Nav = ReactBootstrap.Nav,
    NavItem = ReactBootstrap.NavItem,
    MenuItem = ReactBootstrap.MenuItem;
  return (
  <div>
    <Navbar brand={<a href="#"> React Demo </a>}  toggleNavKey={0} >
      <Nav right eventKey={0}>
        <NavItem eventKey={1} href="index.html">Home</NavItem>
        <NavItem eventKey={2} href="currencies.html">Currencies</NavItem>
        <NavItem eventKey={3} href="stock.html">Stocks</NavItem>
        <NavItem eventKey={3} href="commenttest.html">Comment test</NavItem>
        <NavItem eventKey={3} href="chat.html">Chat</NavItem>
        <NavItem eventKey={3} href="currencies-vanillajs.html">currencies-vanillajs</NavItem>
        <NavDropdown eventKey={3} title="Dropdown" id="collapsible-navbar-dropdown">
          <MenuItem eventKey="1">index</MenuItem>
          <MenuItem eventKey="2" >Currencies</MenuItem>
          <MenuItem divider />
          <MenuItem eventKey="3" >Currencies again</MenuItem>
        </NavDropdown>
      </Nav>
    </Navbar>
    </div>
  );
  }
});
