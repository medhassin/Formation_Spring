# Base image from Oracle
FROM oracle/database:19.3.0-se2
# Switch to root to fix permissions
USER root
# Ensure required directories exist with correct permissions
RUN mkdir -p /opt/oracle/product/19c/dbhome_1/network/log && \
mkdir -p /opt/oracle/oradata && \
mkdir -p /opt/oracle/cfgtoollogs && \
chown -R oracle:oinstall /opt/oracle && \
chmod -R 777 /opt/oracle
# Copy the startup SQL script to create user and grant privileges
COPY init-user.sql /opt/oracle/scripts/startup/
# Set correct permissions for startup script
RUN chown oracle:oinstall /opt/oracle/scripts/startup/init-user.sql && \
chmod 775 /opt/oracle/scripts/startup/init-user.sql
# Expose ports for Oracle DB and EM Express
EXPOSE 1521 5500
# Define mountable volume
VOLUME ["/opt/oracle/oradata"]
# Switch back to oracle user
USER oracle
# Default command (will auto-run DBCA at first startup if DB not initialized)
CMD ["/bin/bash", "-c", "/opt/oracle/runOracle.sh"]
