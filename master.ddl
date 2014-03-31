CREATE TABLE age_ranges (
	id INT NOT NULL PRIMARY KEY,
	name varchar(20) NOT NULL
);

CREATE TABLE genders (
	id INT NOT NULL PRIMARY KEY,
	name varchar(20) NOT NULL
);

CREATE TABLE publishers (
	id INT NOT NULL PRIMARY KEY,
	name varchar(20) NOT NULL
);

CREATE TABLE publications (
	id INT NOT NULL PRIMARY KEY,
	name varchar(20) NOT NULL,
	PublisherId INT NOT NULL,
	FOREIGN KEY (PublisherId) REFERENCES publishers(id)
);

CREATE TABLE asar_instruments (
	id INT NOT NULL PRIMARY KEY,
	GenderId INT NOT NULL,
	AgeRangeId INT NOT NULL,
	FOREIGN KEY (GenderId) REFERENCES genders(id),
	FOREIGN KEY (AgeRangeId) REFERENCES age_ranges(id)
);

CREATE TABLE apar_instruments (
	id INT NOT NULL PRIMARY KEY,
	PublisherId INT NOT NULL,
	PublicationId INT NOT NULL,
	url VARCHAR(2083) NOT NULL,
	FOREIGN KEY (PublisherId) REFERENCES publishers(id),
	FOREIGN KEY (PublicationId) REFERENCES publications(id)
);