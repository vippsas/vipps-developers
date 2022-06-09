FROM node:16 AS builder
COPY . /app
WORKDIR /app
RUN npm ci --omit=dev

FROM gcr.io/distroless/nodejs:16
WORKDIR /app
COPY --chown=nonroot:nonroot --from=builder /app /app
USER nonroot

CMD [ "index.js" ]