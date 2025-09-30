import os
import smtplib
from email.mime.text import MIMEText

# Configurar variáveis de ambiente do GitHub Actions
to_email = os.getenv("EMAIL_TO")
user = os.getenv("EMAIL_USER")
password = os.getenv("EMAIL_PASS")

msg = MIMEText("Pipeline executado com sucesso!")
msg["Subject"] = "Notificação - CI Pipeline"
msg["From"] = user
msg["To"] = to_email

try:
    with smtplib.SMTP("smtp.gmail.com", 587) as server:
        server.starttls()
        server.login(user, password)
        server.sendmail(user, to_email, msg.as_string())
    print("✅ E-mail enviado com sucesso!")
except Exception as e:
    print(f"❌ Erro ao enviar e-mail: {e}")
    exit(1)