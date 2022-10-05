import axios from "axios";
import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const Cart = (props) => {
  const navigate = useNavigate();
  let item = JSON.parse(localStorage.getItem("key"));
  useEffect(() => {
    if (item === null) {
      navigate("/Signin");
    } else if (item.data.aRole === "Admin") {
      navigate("/Unauthorized");
    }
  }, []);
  const { cartItems } = props;
  console.log("Cart - cartItems -> " + cartItems);
  const itemsPrice = cartItems.reduce((a, c) => a + c.qty * c.price, 0);
  const taxPrice = itemsPrice * 0.14;
  const shippingPrice = itemsPrice > 2000 ? 0 : 20;
  const totalPrice = itemsPrice + taxPrice + shippingPrice;
  var quantity;

  var date = new Date();
  var current_date =
    date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
  var current_date2 = current_date.toString();

  var userobj = JSON.parse(localStorage.getItem("key"));
  var eveobj = JSON.parse(localStorage.getItem("eveobj"));

  var bookingObj = {
    bookingPrice: eveobj.eventCost,
    eventName: eveobj.eventName,
    bookingDate: current_date2,
  };
  console.log(bookingObj);

  let bookfunc = async () => {
    await axios
      .post(
        `http://localhost:8083/booking/addBooking.paradise/${userobj.data.visitorId}`,
        bookingObj
      )
      .then(
        (response) => {
          alert("SUCCESS : Booked ");
          document.getElementById("pdf").disabled = false;
          console.log(response.data);
        },
        (error) => {
          console.log(error);
          alert(" ERROR : Booking failed");
        }
      );
  };

  return (
    <>
      <div
        className="btn btn-primary btn-lg"
        style={{ marginLeft: 130 }}
        onClick={bookfunc}
      >
        Book
      </div>
    </>
  );
};

export default Cart;
