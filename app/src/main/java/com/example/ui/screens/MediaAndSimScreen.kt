package com.example.ui.screens

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MainUiState
import com.example.ui.MainViewModel
import com.example.ui.components.SectionCard
import com.example.ui.theme.*
import java.text.NumberFormat
import java.util.*

@Composable
fun MediaAndSimScreen(
    uiState: MainUiState,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var selectedMediaTab by remember { mutableStateOf(0) } // Default to Emulator tools

    val tabs = listOf(
        "Trình Giả Lập & CAD",
        "Pixel Art & LEGO 3D",
        "Speedtest & QR"
    )

    val paletteColors = listOf(
        Color(0xFFE7A03C),
        Color(0xFF1E5F74),
        Color(0xFF0F3057),
        Color(0xFFF9D56E),
        Color(0xFFD63447),
        Color(0xFF222831),
        Color(0xFFFFFFFF),
        Color(0xFF4E9F3D)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp)
    ) {
        item {
            // Segmented Tab Switcher
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                tabs.forEachIndexed { index, title ->
                    val isSelected = selectedMediaTab == index
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isSelected) AccentGold else MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { selectedMediaTab = index }
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.padding(vertical = 10.dp)
                        ) {
                            Text(
                                text = title,
                                fontSize = 11.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) Color.Black else MaterialTheme.colorScheme.onSurface,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }

        if (selectedMediaTab == 0) {
            // ==========================================
            // UPGRADED ADVANCED OS EMULATOR & CAD ENGINE
            // ==========================================
            item {
                val emulatedEnvironments = listOf(
                    "Windows 11 Pro 64-bit" to "Hệ điều hành Windows 11 ảo hóa x86_64, hỗ trợ DirectX 12 Ultimate",
                    "Windows 10 Enterprise" to "Môi trường doanh nghiệp ổn định, tương thích công cụ Sketchware & Java",
                    "Windows XP SP3 (Retro)" to "Giao diện Luna hoài niệm, tối ưu siêu nhẹ cho chip yếu",
                    "Android 17 Vanilla" to "Lõi Android mới nhất với Google Play Services & Sandbox",
                    "iOS 18 (Jailbreak Sandbox)" to "Giả lập môi trường Sileo / TrollStore cài tweak ứng dụng",
                    "Linux Ubuntu 26.04 LTS" to "Môi trường máy chủ lập trình GCC, Python & Docker Container",
                    "SolidWorks 2026 3D CAD" to "Thiết kế cơ khí, mô phỏng lực uốn, xuất bản vẽ kỹ thuật",
                    "SketchUp Pro 2026" to "Dựng hình kiến trúc 3D, phối cảnh quy hoạch công trình đô thị",
                    "Casio fx-880BTG / fx-580VN X" to "Mô phỏng máy tính khoa học thi cử, giải phương trình ma trận",
                    "Retro Game Console (GBA/PSP)" to "Giả lập máy chơi game cầm tay cổ điển với tay cầm ảo"
                )

                var isVmRunning by remember { mutableStateOf(false) }
                var terminalLog by remember {
                    mutableStateOf(
                        "VT-x/AMD-V Hypervisor Ready.\nKernel 6.12.0-generic loaded.\nAllocated 16384 MB RAM (DDR5 Dual Channel).\nNVMe SSD: 512 GB mounted at /dev/nvme0n1.\nDisplay: 2560x1440 2K QHD (144Hz refresh rate).\nSystem ready. Type 'help' or click quick command buttons below."
                    )
                }

                SectionCard(
                    title = "Trình Giả Lập Hệ Điều Hành & Lõi CAD 3D Đa Năng",
                    subtitle = "Windows, Linux, Android, iOS Sandbox, SolidWorks, SketchUp & Casio",
                    icon = Icons.Default.Terminal,
                    badgeText = if (isVmRunning) "MÁY ẢO ĐANG CHẠY" else "SẴN SÀNG KHỞI CHẠY",
                    badgeColor = if (isVmRunning) SuccessGreen else AccentGold
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Text("Chọn Môi Trường Ảo Hóa / Ứng Dụng:", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(emulatedEnvironments) { (envName, _) ->
                                val isSelected = uiState.selectedEmulatorOs == envName
                                FilterChip(
                                    selected = isSelected,
                                    onClick = {
                                        viewModel.updateEmulatorSpecs(
                                            envName,
                                            uiState.emulatorRamGb,
                                            uiState.emulatorRomGb,
                                            uiState.emulatorResolution
                                        )
                                        terminalLog += "\n[Switch-OS] Environment switched to: $envName"
                                    },
                                    label = {
                                        Text(
                                            text = envName,
                                            fontSize = 11.sp,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                                        selectedLabelColor = AccentGold
                                    )
                                )
                            }
                        }

                        // Hardware Configuration Board
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = PrimaryNavy,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Lõi Đang Chọn:", color = Color.White, fontSize = 12.sp)
                                    Text(uiState.selectedEmulatorOs, color = AccentGold, fontWeight = FontWeight.Bold, fontSize = 13.sp)
                                }

                                Divider(color = Color.White.copy(alpha = 0.15f))

                                // RAM Selector
                                Column {
                                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                        Text("Bộ Nhớ RAM:", color = Color.White, fontSize = 12.sp)
                                        Text("${uiState.emulatorRamGb} GB DDR5", color = AccentTeal, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                    }
                                    Slider(
                                        value = uiState.emulatorRamGb.toFloat(),
                                        onValueChange = {
                                            val ram = it.toInt()
                                            viewModel.updateEmulatorSpecs(uiState.selectedEmulatorOs, ram, uiState.emulatorRomGb, uiState.emulatorResolution)
                                        },
                                        valueRange = 2f..48f,
                                        steps = 22,
                                        colors = SliderDefaults.colors(thumbColor = AccentTeal, activeTrackColor = AccentTeal)
                                    )
                                }

                                // Storage Selector
                                Column {
                                    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                        Text("Ổ Cứng Ảo (NVMe SSD):", color = Color.White, fontSize = 12.sp)
                                        Text("${uiState.emulatorRomGb} GB", color = SuccessGreen, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                                    }
                                    Slider(
                                        value = uiState.emulatorRomGb.toFloat(),
                                        onValueChange = {
                                            val rom = it.toInt()
                                            viewModel.updateEmulatorSpecs(uiState.selectedEmulatorOs, uiState.emulatorRamGb, rom, uiState.emulatorResolution)
                                        },
                                        valueRange = 64f..2048f,
                                        steps = 30,
                                        colors = SliderDefaults.colors(thumbColor = SuccessGreen, activeTrackColor = SuccessGreen)
                                    )
                                }

                                // Resolution Badges
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Độ Phân Giải Màn Hình:", color = Color.White, fontSize = 12.sp)
                                    val resList = listOf("1080p FHD", "2K QHD", "4K 144Hz")
                                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        resList.forEach { r ->
                                            val isResSelected = uiState.emulatorResolution.contains(r.split(" ")[0])
                                            Surface(
                                                shape = RoundedCornerShape(6.dp),
                                                color = if (isResSelected) AccentGold else Color.White.copy(alpha = 0.1f),
                                                modifier = Modifier.clickable {
                                                    viewModel.updateEmulatorSpecs(uiState.selectedEmulatorOs, uiState.emulatorRamGb, uiState.emulatorRomGb, r)
                                                }
                                            ) {
                                                Text(
                                                    text = r,
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = if (isResSelected) Color.Black else Color.White,
                                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        // Interactive Simulated Virtual Terminal Console
                        Text("Bảng Điều Khiển & Terminal Giả Lập (Live Console):", fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = Color(0xFF0F172A),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                        Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFFFF5F56)))
                                        Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFFFFBD2E)))
                                        Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(Color(0xFF27C93F)))
                                    }
                                    Text(
                                        text = "root@aistudio-vm:~ (${uiState.selectedEmulatorOs})",
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 10.sp,
                                        color = Color.LightGray
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = terminalLog,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = if (isVmRunning) Color(0xFF4ADE80) else Color(0xFFFBBF24),
                                    lineHeight = 15.sp,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }

                        // Quick Commands for Terminal
                        Text("Lệnh Thao Tác Nhanh:", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val commands = listOf(
                                "neofetch" to "Hiển thị thông tin hệ điều hành & cấu hình CPU/GPU",
                                "ipconfig /all" to "Xem địa chỉ IP ảo & Gateway mạng nội bộ",
                                "benchmark_cad" to "Kiểm tra tốc độ render 3D CAD & khung hình FPS",
                                "casio_eval" to "Tính toán biểu thức toán học: ∫(x²+2x)dx từ 0 đến 5",
                                "clear" to "Xóa sạch màn hình Terminal"
                            )

                            items(commands) { (cmd, _) ->
                                OutlinedButton(
                                    onClick = {
                                        when (cmd) {
                                            "neofetch" -> {
                                                terminalLog = "OS: ${uiState.selectedEmulatorOs}\nHost: AI Studio Hypervisor 2026\nKernel: Linux 6.12.0 / NT 10.0 Hybrid\nUptime: 42 mins\nMemory: ${uiState.emulatorRamGb}GB / 48GB (VIP)\nDisk: ${uiState.emulatorRomGb}GB NVMe SSD\nGPU: NVIDIA GeForce RTX 5090 Virtualized (24GB VRAM)"
                                            }
                                            "ipconfig /all" -> {
                                                terminalLog = "Ethernet adapter eth0:\n  IPv4 Address: 192.168.100.26 (Preferred)\n  Subnet Mask: 255.255.255.0\n  Default Gateway: 192.168.100.1\n  DNS Servers: 8.8.8.8, 1.1.1.1\n  DHCP Enabled: Yes"
                                            }
                                            "benchmark_cad" -> {
                                                terminalLog = "[CAD-BENCHMARK] Running SolidWorks 2026 mesh rendering...\n> Polygon Count: 2,450,000 tris\n> Ray Tracing Samples: 1024\n> Render Time: 1.284 seconds\n> Average FPS: 144.2 FPS (Ultra Smooth)"
                                            }
                                            "casio_eval" -> {
                                                terminalLog = "[Casio fx-880BTG Math Engine]\nExpression: Integrate(x^2 + 2x, 0, 5)\n= [x^3/3 + x^2] from 0 to 5\n= (125/3 + 25) - 0\n= 125/3 + 75/3 = 200/3 ≈ 66.66666667 (Exact Fraction: 200/3)"
                                            }
                                            "clear" -> {
                                                terminalLog = "Terminal cleared. Type commands or choose quick actions."
                                            }
                                        }
                                        Toast.makeText(context, "Đã thực thi lệnh: $cmd", Toast.LENGTH_SHORT).show()
                                    },
                                    modifier = Modifier.height(36.dp),
                                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Text(cmd, fontFamily = FontFamily.Monospace, fontSize = 11.sp)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        // Launch / Power VM Button
                        Button(
                            onClick = {
                                isVmRunning = !isVmRunning
                                if (isVmRunning) {
                                    terminalLog = "[BOOT] Khởi động thành công ${uiState.selectedEmulatorOs}!\n- Cấp phát: ${uiState.emulatorRamGb} GB RAM | ${uiState.emulatorRomGb} GB SSD\n- Độ phân giải: ${uiState.emulatorResolution}\n- Âm thanh: Web Audio API 48kHz Stereo\n- Trạng thái: Ready for interaction."
                                    Toast.makeText(context, "Khởi chạy máy ảo ${uiState.selectedEmulatorOs} thành công!", Toast.LENGTH_SHORT).show()
                                } else {
                                    terminalLog = "[HALT] Đã tắt và lưu trạng thái snapshot máy ảo an toàn."
                                    Toast.makeText(context, "Đã tắt máy ảo an toàn!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isVmRunning) AccentRed else PrimaryNavy
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("btn_toggle_vm_power")
                        ) {
                            Icon(
                                imageVector = if (isVmRunning) Icons.Default.Stop else Icons.Default.PowerSettingsNew,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isVmRunning) "Tắt & Lưu Trạng Thái Máy Ảo (Shutdown)" else "Khởi Chạy Máy Ảo Giả Lập (${uiState.selectedEmulatorOs})",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        } else if (selectedMediaTab == 1) {
            // PIXEL ART & LEGO 3D
            item {
                SectionCard(
                    title = "Bảng Vẽ Pixel Art 16x16",
                    subtitle = "Vẽ texture, block và nhân vật tùy biến Minecraft",
                    icon = Icons.Default.Brush,
                    badgeText = "Pixel Art 2026"
                ) {
                    Text("Bảng màu vẽ Pixel:", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(paletteColors) { color ->
                            val isSelected = uiState.selectedPixelColor == color
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .clickable { viewModel.selectPaletteColor(color) },
                                contentAlignment = Alignment.Center
                            ) {
                                if (isSelected) {
                                    Icon(
                                        Icons.Default.Check,
                                        contentDescription = "Selected",
                                        tint = if (color == Color.White || color == AccentGold) Color.Black else Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // 16x16 Grid
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(8.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(1.5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            for (r in 0 until 16) {
                                Row(horizontalArrangement = Arrangement.spacedBy(1.5.dp)) {
                                    for (c in 0 until 16) {
                                        val pixelColor = uiState.pixelArtGrid[r][c]
                                        Box(
                                            modifier = Modifier
                                                .size(16.dp)
                                                .clip(RoundedCornerShape(2.dp))
                                                .background(pixelColor)
                                                .clickable { viewModel.setPixelColor(r, c) }
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedButton(
                            onClick = { viewModel.clearPixelGrid() },
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.DeleteOutline, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Làm Mới")
                        }
                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã lưu ảnh Pixel Art dưới dạng tệp texture.png!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Default.SaveAlt, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.White)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Lưu .png", color = Color.White)
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Chuyển Đổi Mô Hình 3D Sang LEGO",
                    subtitle = "Ước tính số lượng viên gạch và chi phí mua lẻ Creator",
                    icon = Icons.Default.Category,
                    badgeText = "LEGO Studio"
                ) {
                    val themes = listOf("Creator", "City", "Ninjago", "Minecraft", "Icons", "Friends")
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(themes) { theme ->
                            val isSelected = uiState.selectedLegoTheme == theme
                            FilterChip(
                                selected = isSelected,
                                onClick = { viewModel.selectLegoTheme(theme) },
                                label = { Text("LEGO $theme") }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    val currencyFmt = NumberFormat.getCurrencyInstance(Locale("vi", "VN")).format(uiState.legoEstimatedCostVnd)
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text("Dòng LEGO chuyển đổi:", fontSize = 13.sp)
                                Text(uiState.selectedLegoTheme, fontWeight = FontWeight.Bold, color = AccentGold)
                            }
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text("Tổng số mảnh gạch ước tính:", fontSize = 13.sp)
                                Text("${uiState.legoPiecesEstimated} Mảnh", fontWeight = FontWeight.Bold, color = AccentTeal)
                            }
                            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                Text("Ước tính chi phí mua lẻ:", fontSize = 13.sp)
                                Text(currencyFmt, fontWeight = FontWeight.Bold, color = SuccessGreen)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            Toast.makeText(context, "Đã xuất toàn bộ hướng dẫn lắp ráp LEGO (.zip) độ phân giải cao!", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = AccentGold),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.FolderZip, contentDescription = null, tint = Color.Black)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Xuất Toàn Bộ Hướng Dẫn Lắp Ráp (.zip)", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }
        } else {
            // SPEEDTEST & QR CODE
            item {
                SectionCard(
                    title = "Kiểm Tra Tốc Độ Mạng (Speedtest)",
                    subtitle = "Băng tần 2.4GHz (88 Mbps) & 5GHz (476 Mbps) với Ping/Jitter",
                    icon = Icons.Default.Speed,
                    badgeText = "Speedtest VN",
                    badgeColor = AccentTeal
                ) {
                    val animatedDownload by animateFloatAsState(targetValue = uiState.downloadSpeedMbps, label = "dl")

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Big Gauge Indicator
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(140.dp)
                                .clip(CircleShape)
                                .background(
                                    Brush.radialGradient(
                                        listOf(PrimaryLightBlue.copy(alpha = 0.4f), PrimaryNavy)
                                    )
                                )
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = String.format("%.1f", animatedDownload),
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = AccentGold
                                )
                                Text("Mbps Tải Xuống", fontSize = 11.sp, color = TextSecondaryDark)
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Độ trễ (Ping)", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("${uiState.pingMs} ms", fontWeight = FontWeight.Bold, color = SuccessGreen, fontSize = 15.sp)
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Độ lệch (Jitter)", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text("${uiState.jitterMs} ms", fontWeight = FontWeight.Bold, color = AccentTeal, fontSize = 15.sp)
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Tốc độ Tải Lên", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text(String.format("%.1f Mbps", uiState.uploadSpeedMbps), fontWeight = FontWeight.Bold, color = AccentGold, fontSize = 15.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Button(
                            onClick = { viewModel.startSpeedTest() },
                            enabled = !uiState.isTestingSpeed,
                            colors = ButtonDefaults.buttonColors(containerColor = AccentGold),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("btn_start_speedtest")
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (uiState.isTestingSpeed) "Đang Đo Tốc Độ Mạng..." else "Bắt Đầu Kiểm Tra Tốc Độ",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Trình Tạo Mã QR Code & Mã Vạch",
                    subtitle = "Tùy biến trực tuyến và ngoại tuyến cho liên kết",
                    icon = Icons.Default.QrCode2,
                    badgeText = "QR Code Gen"
                ) {
                    var qrText by remember { mutableStateOf(uiState.qrInputText) }
                    OutlinedTextField(
                        value = qrText,
                        onValueChange = { qrText = it },
                        label = { Text("Nội Dung Mã QR / Đường Dẫn") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // QR Visual Mock Card
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.QrCodeScanner,
                                contentDescription = "QR Code Preview",
                                tint = Color.Black,
                                modifier = Modifier.size(100.dp)
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = qrText,
                                color = Color.Black,
                                fontSize = 11.sp,
                                maxLines = 1,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            Toast.makeText(context, "Đã xuất mã QR Code độ phân giải cao (.png)!", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Download, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tải Mã QR Về Máy (.png)", color = Color.White)
                    }
                }
            }
        }
    }
}
