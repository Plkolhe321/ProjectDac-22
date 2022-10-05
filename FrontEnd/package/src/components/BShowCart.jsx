import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import Navbarr from "./Navbar";
import Itemcard from "./BItemcard";
import Cart from "./BCart";

export default function ShowCart() {
  const location = useLocation();
  const navigate = useNavigate();
  let item = JSON.parse(localStorage.getItem("key"));

  useEffect(() => {
    if (item === null) {
      navigate("/Signin");
    } else if (item.data.aRole === "Admin") {
      navigate("/Unauthorized");
    }
  }, []);

  const [pdata, setPdata] = useState([{}]);

  const [cartItems, setCartItems] = useState([]);

  const onAdd = (newProduct) => {
    console.log("here................", newProduct);

    const exist = cartItems.find((x) => x.eventId === newProduct.eventId);

    console.log(exist, ".................here");

    if (exist) {
      setCartItems(
        cartItems.map((x) =>
          x.eventId === newProduct.eventId
            ? { ...exist, qty: exist.qty + 1 }
            : x
        )
      );
    } else {
      setCartItems([...cartItems, { ...newProduct, qty: 1 }]);
      console.log("else ", cartItems);
    }
  };
  const onRemove = (newProduct) => {
    const exist = cartItems.find((x) => x.eventId === newProduct.eventId);
    if (exist.qty === 1) {
      setCartItems(cartItems.filter((x) => x.eventId !== newProduct.eventId));
    } else {
      setCartItems(
        cartItems.map((x) =>
          x.eventId === newProduct.eventId
            ? { ...exist, qty: exist.qty - 1 }
            : x
        )
      );
    }
  };

  console.log(location.state.eventName);
  // async function abc()
  let eveObj = async () =>
    await axios
      .get(
        `http://localhost:8083/event/find.paradise2/${location.state.eventName}`
      )
      .then((response) => {
        setPdata(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        alert(error);
      });

  useEffect(() => {
    eveObj();
  }, []);

  localStorage.setItem("eveobj", JSON.stringify(pdata));

  return (
    <>
      <Navbarr />

      <h1 className="text-center text-info">............</h1>

      <div
        className="row "
        style={{
          //   backgroundImage: "url(" + farm + ")",
          backgroundSize: "cover",
          height: "100vh",
          opacity: 1,
        }}
      >
        <div className="block col-11  m-4">
          <div className="row">
            {
              <>
                <div className="col-4 mb-4">
                  {/* <p>{item.categories}</p> */}
                  <Itemcard
                    item={pdata}
                    key={pdata.eventId}
                    onAdd={onAdd}
                    onRemove={onRemove}
                  />
                  <Cart
                    onAdd={onAdd}
                    onRemove={onRemove}
                    cartItems={cartItems}
                  />
                </div>
              </>
            }
            <div className="col">
              <img
                src="https://images.pexels.com/photos/1271619/pexels-photo-1271619.jpeg

                "
                height={500}
                width={800}
              ></img>
              <Link
                to="/ShowPdf"
                state={{
                  eve: JSON.parse(localStorage.getItem("eveobj")),
                }}
              >
                <div class="btn btn-primary btn-lg" id="pdf" disabled>
                  View Pdf
                </div>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
