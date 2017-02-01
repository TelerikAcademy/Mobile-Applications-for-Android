const express = require("express"),
    bodyParser = require("body-parser");

let app = express();

app.use(bodyParser.json());

let books = [
    { id: 1, title: "The Fellowship of the Ring" },
    { id: 2, title: "The Two Towers" },
    { id: 3, title: "The return of the King" },
    { id: 4, title: "Hobbit" }
];

app.get("/api/books", (req, res) => {
    setTimeout(() => {
        res.send(books);
    }, 3000);
});

app.get("/api/books/:id", (req, res) => {
    setTimeout(() => {
        res.send(books[req.params.id - 1]);
    }, 3000);
});

app.listen(3001,
    () => console.log("Application running at :3001"));