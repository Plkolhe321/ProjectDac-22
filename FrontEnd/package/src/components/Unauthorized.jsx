import { color } from "@mui/system";

export default function Unauthorized() {
  return (
    <>
      <div
        className="col-11 col-md-10 h3"
        style={{
          fontFamily: "cursive",
          textAlign: "center",
          color: "red",
          margin: 100,
        }}
      >
        <h3>Unauthorized access is not allowed.</h3>
      </div>
    </>
  );
}
