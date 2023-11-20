import Sequelize from "sequelize";

import sequelize from "../../../config/db/dbConfig.js";

const User = sequelize.define(
    "user",
    {
        id: {
            type: Sequelize.INTEGER,
            autoIncrement: true,
            allowNull: false,
            primaryKey: true
        },
        name: {
            type: Sequelize.STRING(60), 
            allowNull: false, 
        },
        email:{
            type: Sequelize.STRING(60),
            allowNull: false,  

        },
        password:{
            type: Sequelize.STRING(100), 
            allowNull: false, 
        },
    },
    {}
);

export default User;