package cl.duoc.login.controller;

import cl.duoc.login.dto.request.DtoAuthRequest;
import cl.duoc.login.dto.response.DtoAuthResponse;
import cl.duoc.login.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Indica que esta clase es un controlador REST
@RestController

// Define la ruta base del controlador
@RequestMapping("/api/v1/auth")

// Genera constructor con atributos final
@RequiredArgsConstructor

//Documentacion swagger
@Tag(name = "Autentificacion", description = "Operaciones de autentificacion y manejo de usuario")
public class AuthController {

    // Inyecta el servicio de autenticación
    private final AuthService authService;

    // Define endpoint POST /api/v1/auth/login
    @PostMapping("/login")
    //Documentacion Swagger
    @Operation(summary = "Obtener el token JWT", description = "Entrega el token JWT validando user y pass")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
        @ApiResponse(responseCode = "403",description = "Usuario o pass son invalidos"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<DtoAuthResponse> login(

            // Recibe el JSON del body y valida sus campos
            @Valid @RequestBody DtoAuthRequest request) {

        // Llama al servicio para validar credenciales y generar token
        DtoAuthResponse response = authService.login(request);

        // Retorna HTTP 200 OK con el token
        return ResponseEntity.ok(response);
    }
}