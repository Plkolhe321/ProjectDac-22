import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import AdminNav from "./AdminNav";

function VisitorList() {
  const [responseData, setResponseData] = useState([]);
  const navigate = useNavigate();
  let item = JSON.parse(localStorage.getItem("key"));
  useEffect(() => {
    if (item === null) {
      navigate("/Signin");
    } else if (item.data.aRole === "Visitor") {
      navigate("/Unauthorized");
    }
  }, []);

  const visitorList = () => {
    axios
      .get("http://localhost:8083/visitor/find.paradise")
      .then((response) => {
        setResponseData(response.data);
      })
      .catch((error) => {
        alert(error);
      });
  };

  useEffect(() => {
    visitorList();
  }, []);

  const visitorDelete = (evnt) => {
    axios
      .delete(
        `http://localhost:8083/visitor/delete.paradise/${evnt.target.value}`
      )
      .then((response) => {
        visitorList();
      })
      .catch((error) => {
        alert("You have to first delete your review...");
      });
  };

  const [user2, setUser2] = useState([
    {
      bookingPrice: "",
      bookingDate: "",
      eventName: "",
      campName: "",
      visitor: { visitorId: "" },
    },
  ]);

  const loadUser2 = async () => {
    const rev = await axios.get(`http://localhost:8083/booking/find.paradise`);
    setUser2(rev.data);
  };
  useEffect(() => {
    loadUser2();
  }, []);
  console.log(" booking deatails " + user2);

  return (
    <>
      <AdminNav />
      <div class="container mt-3">
        <h2>Visitor Information</h2>

        <table class="table table-striped">
          <thead>
            <tr>
              <th>AadharNo.</th>
              <th>Name</th>
              <th>MobileNo.</th>
              <th>Email</th>
              <th>UserName</th>
              <th>
                <Link to="/list/eventlist" class="btn btn-primary">
                  Event List
                </Link>
              </th>
            </tr>
          </thead>
          <tbody>
            {responseData.map((val) => (
              <tr key="{val.id}">
                <td>{val.aadharno}</td>
                <td>{val.name}</td>
                <td>{val.mobno}</td>
                <td>{val.email}</td>
                <td>{val.username}</td>
                {/* <td>
                  <button
                    type="button"
                    className="badge bg-danger"
                    id={val.id}
                    value={val.visitorId}
                    onClick={visitorDelete}
                  >
                    X
                  </button>{" "}
                </td> */}
              </tr>
            ))}
          </tbody>
        </table>

        <h1>Customer Bookings</h1>
        <table class="table table-striped">
          <thead>
            <tr>
              <th>Booking Price</th>
              <th>Booking Date</th>
              <th>Event Name</th>
              <th>Visitor Name</th>
            </tr>
          </thead>
          <tbody>
            {user2.map((val) => (
              <tr key="{val.bookingId}">
                {console.log("dvs " + val.bookingPrice)}
                <td>{val.bookingPrice}</td>
                <td>{val.bookingDate}</td>
                <td>{val.eventName}</td>
                <td>{val.visitor.name}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}
export default VisitorList;
