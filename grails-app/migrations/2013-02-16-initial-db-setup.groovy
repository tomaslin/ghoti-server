databaseChangeLog = {

	changeSet(author: "tomaslin (generated)", id: "1361055475053-1") {
		createTable(tableName: "project_templates") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "project_templPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "approved", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-2") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-3") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "boolean") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-4") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-5") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-8") {
		createIndex(indexName: "authority_uniq_1361055474755", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-9") {
		createIndex(indexName: "username_uniq_1361055474771", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-6") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46ADFE1E8AE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "tomaslin (generated)", id: "1361055475053-7") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A850CAC8E", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
