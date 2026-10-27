CREATE TABLE IF NOT EXISTS schedules (
                                         id SERIAL PRIMARY KEY,
                                         title VARCHAR(100) NOT NULL,
                                         description TEXT,
                                         date DATE NOT NULL,
                                         start_time TIME,
                                         end_time TIME,
                                         category VARCHAR(50),
                                         completed BOOLEAN NOT NULL DEFAULT FALSE
);