var Navbar = React.createClass ({
  render: function() {

    var Navbar = ReactBootstrap.Navbar,
    NavBrand = ReactBootstrap.NavBrand,
    NavDropdown = ReactBootstrap.NavDropdown,
    Nav = ReactBootstrap.Nav,
    NavItem = ReactBootstrap.NavItem,
    MenuItem = ReactBootstrap.MenuItem;
  return (
  <div>
    <Navbar brand={<a href="index.html"> React Demo </a>}  toggleNavKey={0} >
      <Nav right eventKey={0}>
        <NavItem eventKey={1} href="index.html">Home</NavItem>
        <NavItem eventKey={2} href="currencies.html">Currencies</NavItem>
        <NavItem eventKey={3} href="statistics.html">Stats</NavItem>
        <NavItem eventKey={4} href="vanilla-vs-react.html">JS vs React</NavItem>
        <NavDropdown eventKey={4} title="Test Cases" id="basic-nav-dropdown">
        <MenuItem eventKey="1" href="brutejs-currency.html">BruteJS currency</MenuItem>
        <MenuItem eventKey="2" href="smartjs-currency.html">SmartJS currency</MenuItem>
        <MenuItem eventKey="3" href="reactjs-currency.html">React currency</MenuItem>
        <MenuItem divider />
        <MenuItem eventKey="1" href="currencies-vanillajs.html">Currencies VanillaJS</MenuItem>
        <MenuItem eventKey="2" href="currencies-smartjs.html">Currencies SmartJS</MenuItem>
        <MenuItem eventKey="3" href="currencies-react.html">Currencies ReactJS</MenuItem>
        <MenuItem divider />
        </NavDropdown>
      </Nav>
    </Navbar>
    </div>
  );
  }
});
