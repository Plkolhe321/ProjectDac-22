import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

import AdminNav from "./AdminNav";

const EventAdd = () => {
  const navigate = useNavigate();
  let item = JSON.parse(localStorage.getItem("key"));
  useEffect(() => {
    if (item === null) {
      navigate("/Signin");
    } else if (item.data.aRole === "Visitor") {
      navigate("/Unauthorized");
    }
  }, []);

  const [inputs, setInputs] = useState({});
  const handleChange = (evnt) => {
    let paramName = evnt.target.name;
    let paramValue = evnt.target.value;
    console.log(paramName);
    console.log(paramValue);
    setInputs((values) => ({ ...values, [paramName]: paramValue }));
  };

  const handleSubmit = (evnt) => {
    evnt.preventDefault();

    axios
      .post("http://localhost:8083/event/addEvent.paradise", inputs)
      .then((response) => {
        window.location.href = "/list/eventlist";
      })
      .catch((error) => {
        alert(error);
      });
  };

  return (
    <div>
      <AdminNav title="EventAdd" />
      <div className="form-control">
        <form className="col g-3">
          <div className="mb-3">
            <label className="form-label">Event Name : </label>
            <input
              type="text"
              name="eventName"
              value={inputs.eventName}
              onChange={handleChange}
              className="form-control"
              style={{ marginBottom: 20 }}
            />
          </div>
          <div className="col-md-6">
            <label className="form-label">Event Duration : </label>
            <input
              type="text"
              name="eventDate"
              value={inputs.eventDate}
              onChange={handleChange}
              className="form-control"
              style={{ marginBottom: 20 }}
            />
          </div>
          <div className="col-md-6">
            <label className="form-label">Event Cost : </label>
            <input
              type="number"
              name="eventCost"
              value={inputs.eventCost}
              onChange={handleChange}
              className="form-control"
              style={{ marginBottom: 20 }}
            />
          </div>

          <div className="col-12" style={{ marginTop: 40 }}>
            {" "}
            <button
              type="submit"
              className="btn btn-primary w-100 mt-2"
              onClick={handleSubmit}
            >
              Add Event
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default EventAdd;
