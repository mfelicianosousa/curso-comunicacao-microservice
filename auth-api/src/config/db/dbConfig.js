import Sequelize from "sequelize";

const sequelize = new Sequelize("auth-db","admin","123456",{
    host: "localhost",
    dialect: "postgres",
    port: 5434,
    quoteIndentifiers: false,
    define: {
        syncOnAssociation: true,
        timestamps: false,
        underscoredAll: true,
        freezeTableName: true,
    },
});

sequelize.authenticate().then(() =>{
    console.info("Connection has been stabished!");
}).catch((err) =>{
    console.error("Unable to connect to the database.");
    console.error(err.message);
});

export default sequelize;
