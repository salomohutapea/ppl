import express from "express";
const app = express();
import cors from "cors";
import bodyParser from "body-parser";

//Middleware
app.use(bodyParser.json());
app.use(cors());

app.get("/", (_req, res) => {
  res.send({
    DIAGONAL_DIFFERENCE: true,
    MIN_MAX_SUM: true,
  });
});

app.listen(process.env.PORT || 2000);
