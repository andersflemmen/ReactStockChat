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
        <NavItem eventKey={3} href="commenttest.html">Comment test</NavItem>
        <NavItem eventKey={3} href="chat.html">Chat</NavItem>
        <NavItem eventKey={3} href="currencies-vanillajs.html">Currencies-vanillajs</NavItem>
      </Nav>
    </Navbar>
    </div>
  );
  }
});
