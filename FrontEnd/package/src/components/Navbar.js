import { Container, Nav, Navbar } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import logo from "../assets/logo.jpeg";

function Navbarr(props) {
  let isLogin = localStorage.getItem("key");
  console.log(props);
  return (
    <>{isLogin ? <Navbarr4LoggedInUser /> : <Navbarr4NotLoggedInUser />}</>
  );
}

function Navbarr4LoggedInUser() {
  let navigate = useNavigate();

  const processLogout = () => {
    localStorage.clear();
    navigate("/Signin");
  };
  var item = JSON.parse(localStorage.getItem("key"));

  return (
    <>
      <Navbar bg="success" variant="dark" expand="lg">
        <Container>
          {/* <img style={{ height: 50, width: 60 }} src={logo} alt="" /> */}
          <Navbar.Brand as={Link} to="/">
            Traveler's Paradise
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>
              <Nav.Link as={Link} to="/profile">
                Profile
              </Nav.Link>
              <Nav.Link as={Link} to="/review">
                Review
              </Nav.Link>
              <Nav.Link as={Link} to="/aboutus">
                About Us
              </Nav.Link>

              <Nav.Link onClick={processLogout}>Logout</Nav.Link>
              <strong style={{ marginLeft: 20, marginTop: 8, color: "white" }}>
                Welcome {item.data.name}
              </strong>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
}

function Navbarr4NotLoggedInUser() {
  return (
    <>
      <Navbar bg="success" variant="dark" expand="lg">
        <Container>
          <Navbar.Brand as={Link} to="/">
            Traveler's Paradise
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>
              <Nav.Link as={Link} to="/aboutus">
                About Us
              </Nav.Link>
              <Nav.Link as={Link} to="/Signin">
                Login
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
}

export default Navbarr;

// import { Button } from "bootstrap";
// import { Link } from "react-router-dom";

// export default function Navbar() {

//   var item = JSON.parse(localStorage.getItem("key"));

//   const removeSession = () => {

//     localStorage.removeItem("key");
//     window.location.href = "/Signin";
//   };
//   return (

//     <nav id="navmain" class="navbar navbar-expand-lg navbar-dark bg-success sticky-top">
//       <div class="container-fluid">
//         <Link
//           to="/"
//           className="navbar-brand px-4 text-info"
//         >
//          <b> Traveler's Paradise</b>

//         </Link>

//         <button
//           class="navbar-toggler"
//           type="button"
//           data-bs-toggle="collapse"
//           data-bs-target="#navbarNav"
//           aria-controls="navbarNav"
//           aria-expanded="false"
//           aria-label="Toggle navigation"
//         >
//           <span class="navbar-toggler-icon"></span>
//         </button>
//         <div class="collapse navbar-collapse" id="navbarNav">
//           <ul class="navbar-nav ">
//             <li class="nav-item p-2 mx-4 ml-5">
//               <Link
//                 to="/"
//                 style={{ textDecoration: "none", color: "white" }}
//               >
//                 <b>Home</b>
//               </Link>
//             </li>
//             <li class="nav-item p-2 mx-4">
//               <Link
//                 to="/profile"
//                 style={{ textDecoration: "none", color: "white" }}
//               >
//                 <b>Profile</b>
//               </Link>
//             </li>
//             <li class="nav-item p-2 mx-4">
//               <Link
//                 to="/review"
//                 style={{ textDecoration: "none", color: "white" }}
//               >
//               <b> Review</b>
//               </Link>
//             </li>
//             <li class="nav-item p-2 mx-4 mr-5">
//             <Link
//               to="/aboutus"
//               style={{ textDecoration: "none", color: "white" }}
//             >
//             <b>  About Us</b>
//             </Link>
//             </li>
//             <li class="nav-item mx-5 ml-5">
//             <Link to="/" style={{ textDecoration: "none", color: "white" }}>
//               <button className="btn btn-success " onClick={removeSession}>
//                 {" "}
//                 Logout
//               </button>
//             </Link>

//             </li>
//             <li><strong>Welcome {item.data.name}</strong>
//     </li>
//           </ul>
//         </div>
//       </div>
//     </nav>
//   );
// }
