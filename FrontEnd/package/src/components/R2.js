import axios from "axios";
import { useEffect, useState } from "react";
import AdminNav from "./AdminNav";

function Review() {
  let item = JSON.parse(localStorage.getItem("key"));

  //Add
  const [inputs1, setInputs1] = useState({});

  const handleChange1 = (evnt) => {
    let paramName = evnt.target.name;
    let paramValue = evnt.target.value;
    console.log(paramName);
    console.log(paramValue);
    setInputs1((values) => ({ ...values, [paramName]: paramValue }));
  };

  const handleSubmit1 = (evnt) => {
    evnt.preventDefault();
    //alert(JSON.stringify(inputs1));

    axios
      .post(
        `http://localhost:8083/review/addReview.paradise/${item.data.username}`,
        inputs1
      )
      .then((response) => {
        alert(response.data);
        reviewList();
      })
      .catch((error) => {
        alert(error);
      });
  };

  //list
  const [responseData, setResponseData] = useState([]);

  const reviewList = () => {
    axios
      .get("http://localhost:8083/review/find.paradise")
      .then((response) => {
        setResponseData(response.data);
      })
      .catch((error) => {
        alert(error);
      });
  };

  useEffect(() => {
    reviewList();
  }, []);

  //delete
  const reviewDelete = (evnt) => {
    console.log(evnt.target.value);
    axios
      .delete(
        `http://localhost:8083/review/delete.paradise/${evnt.target.value}`
      )
      .then((response) => {
        reviewList();
      })
      .catch((error) => {
        alert("review not exist");
      });
  };

  return (
    <div>
      <AdminNav />

      <h1 className="bg-primary text-light p-2 m-10  ">Reviews</h1>

      {/** DISPLAY THE LIST */}
      <table class="table">
        <thead>
          <tr>
            <th>ReviewId</th>
            {/* <th scope="col">Username</th> */}
            <th scope="col">Review</th>
            <th scope="col">Name</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {responseData.map((val) => (
            <tr key={val.reviewId}>
              <td>{val.reviewId}</td>
              <td>{val.description}</td>
              <td>{val.visitor.name}</td>

              <td>
                <button
                  className="badge bg-danger "
                  id={val.reviewId}
                  value={val.reviewId}
                  onClick={reviewDelete}
                >
                  X
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Review;
