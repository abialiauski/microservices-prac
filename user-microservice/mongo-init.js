db.createUser(
    {
        user: "def_user",
        pwd: "pass",
        roles: [
            {
                role: "readWrite",
                db: "user-ms"
            }
        ]
    }
);