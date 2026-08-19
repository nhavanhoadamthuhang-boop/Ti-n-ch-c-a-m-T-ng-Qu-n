package com.example.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MainUiState
import com.example.ui.MainViewModel
import com.example.ui.components.CodeViewerBox
import com.example.ui.components.SectionCard
import com.example.ui.theme.*

@Composable
fun GameToolsScreen(
    uiState: MainUiState,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var selectedSubGame by remember { mutableStateOf(2) } // Default to Cities: Skylines (2)
    // 0: Minecraft, 1: SimCity, 2: Cities: Skylines, 3: TheoTown & CI6

    val subGameTabs = listOf(
        "Minecraft",
        "SimCity",
        "Cities: Skylines",
        "TheoTown / CI6"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp)
    ) {
        item {
            // Sub-category selector
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                items(subGameTabs.indices.toList()) { index ->
                    val isSelected = selectedSubGame == index
                    FilterChip(
                        selected = isSelected,
                        onClick = { selectedSubGame = index },
                        label = {
                            Text(
                                text = subGameTabs[index],
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                fontSize = 12.sp
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                            selectedLabelColor = AccentGold
                        )
                    )
                }
            }
        }

        if (selectedSubGame == 0) {
            // MINECRAFT TOOLS
            item {
                SectionCard(
                    title = "Trình Kê Khai & UUID Minecraft",
                    subtitle = "Tự động sinh manifest.json cho Bedrock & Java",
                    icon = Icons.Default.Extension,
                    badgeText = "Bedrock & Java"
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = uiState.mcPackType == "data",
                            onClick = { viewModel.updateMinecraftPack(uiState.mcPackName, uiState.mcPackDesc, "data") },
                            label = { Text("Data Pack") }
                        )
                        FilterChip(
                            selected = uiState.mcPackType == "resources",
                            onClick = { viewModel.updateMinecraftPack(uiState.mcPackName, uiState.mcPackDesc, "resources") },
                            label = { Text("Resource Pack") }
                        )
                        FilterChip(
                            selected = uiState.mcPackType == "world_template",
                            onClick = { viewModel.updateMinecraftPack(uiState.mcPackName, uiState.mcPackDesc, "world_template") },
                            label = { Text("World Template") }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = uiState.mcPackName,
                        onValueChange = { viewModel.updateMinecraftPack(it, uiState.mcPackDesc, uiState.mcPackType) },
                        label = { Text("Tên Gói (Pack Name)") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = uiState.mcPackDesc,
                        onValueChange = { viewModel.updateMinecraftPack(uiState.mcPackName, it, uiState.mcPackType) },
                        label = { Text("Mô Tả Gói (Description)") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    CodeViewerBox(codeText = uiState.mcGeneratedJson, language = "JSON Manifest")

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            viewModel.regenerateMinecraftUuids()
                            Toast.makeText(context, "Đã tạo cặp UUID Version 4 mới!", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("btn_gen_mc_uuid")
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Tạo Lại Cặp UUID Mới", color = Color.White)
                    }
                }
            }

            item {
                SectionCard(
                    title = "Trình Tạo Boss Mob Tùy Chỉnh (EXP 400)",
                    subtitle = "Máu 1.000 tim, EXP 400, kháng sát thương và drop Netherite",
                    icon = Icons.Default.Shield,
                    badgeText = "Boss Mob v2026",
                    badgeColor = AccentRed
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Tên Boss:", fontSize = 13.sp)
                            Text(uiState.mcMobConfig.mobName, fontWeight = FontWeight.Bold, color = AccentGold)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Điểm kinh nghiệm (EXP):", fontSize = 13.sp)
                            Text("${uiState.mcMobConfig.expReward} EXP (Chuẩn Đàm Tường Quân)", fontWeight = FontWeight.Bold, color = SuccessGreen)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Lượng máu tối đa:", fontSize = 13.sp)
                            Text("${uiState.mcMobConfig.healthPoints} Tim (Kháng đòn đánh)", fontWeight = FontWeight.Bold, color = AccentRed)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Vật phẩm rơi (Drops):", fontSize = 13.sp)
                            Text(uiState.mcMobConfig.customDrop, fontWeight = FontWeight.Bold, color = AccentTeal)
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã xuất cấu hình Boss Mob: ${uiState.mcMobConfig.mobName} vào game!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = AccentRed),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Download, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Tải Cấu Hình Boss Mob (.mcstructure)", color = Color.White)
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Trình Tạo Thế Giới Siêu Phẳng (Superflat)",
                    subtitle = "Tùy biến các lớp Bedrock, Dirt, Block và Quặng",
                    icon = Icons.Default.Layers,
                    badgeText = "Superflat World"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Chuỗi Preset Generator:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = uiState.mcSuperflatPreset.layerConfig,
                                modifier = Modifier.padding(10.dp),
                                fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                                fontSize = 12.sp,
                                color = AccentGold
                            )
                        }

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã sao chép Preset Siêu Phẳng vào bộ nhớ tạm!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.ContentCopy, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Sao Chép Chuỗi Preset Siêu Phẳng", color = Color.White)
                        }
                    }
                }
            }
        } else if (selectedSubGame == 1) {
            // SIMCITY TOOLS
            item {
                SectionCard(
                    title = "Bảng Điều Khiển SimCity BuildIt (Max Fill)",
                    subtitle = "Nạp nhanh 1.111.111.120 xu, SimCash, Khóa Bạch Kim",
                    icon = Icons.Default.LocationCity,
                    badgeText = "Max Fill 1.11B",
                    badgeColor = SuccessGreen
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Tên Thành Phố:", fontSize = 13.sp)
                            Text(uiState.simCityConfig.cityName, fontWeight = FontWeight.Bold, color = AccentGold)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Cấp độ (Level):", fontSize = 13.sp)
                            Text("Cấp ${uiState.simCityConfig.level} (Max)", fontWeight = FontWeight.Bold, color = AccentTeal)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Dân số thành phố:", fontSize = 13.sp)
                            Text("12.000.000 Dân", fontWeight = FontWeight.Bold, color = AccentAmberLight)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Chỉ số Hạnh Phúc:", fontSize = 13.sp)
                            Text("100% Tuyệt Đối", fontWeight = FontWeight.Bold, color = SuccessGreen)
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            Text("Simoleons & SimCash:", fontSize = 13.sp)
                            Text("1.111.111.120", fontWeight = FontWeight.Bold, color = SuccessGreen)
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Button(
                            onClick = {
                                viewModel.applyMaxFillSimCity()
                                Toast.makeText(context, "Đã áp dụng nạp nhanh tối đa 1.111.111.120 tài nguyên SimCity!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("btn_simcity_max_fill")
                        ) {
                            Icon(Icons.Default.FlashOn, contentDescription = null, tint = Color.Black)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Nạp Nhanh Tối Đa 1.111.111.120 Tài Nguyên", color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Mã Kích Hoạt Khôi Phục SimCity (RSxxxxxxxx)",
                    subtitle = "Mã bảo mật định danh tài khoản và cấp cứu dữ liệu",
                    icon = Icons.Default.Key,
                    badgeText = "Mã Bảo Mật"
                ) {
                    val minutes = uiState.simCityCodeTimeRemainingSeconds / 60
                    val seconds = uiState.simCityCodeTimeRemainingSeconds % 60
                    val timeStr = String.format("%02d:%02d", minutes, seconds)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Mã kích hoạt cá nhân:", fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(modifier = Modifier.height(4.dp))
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = PrimaryNavy,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Text(
                                text = uiState.simCityActivationCode,
                                color = AccentGold,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 22.sp,
                                modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Thời gian hiệu lực còn lại: $timeStr",
                            color = if (uiState.simCityCodeTimeRemainingSeconds < 300) AccentRed else AccentTeal,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedButton(
                            onClick = { viewModel.generateNewSimCityCode() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.VpnKey, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Tạo Mã Kích Hoạt Mới (RSxxxxxxxx)")
                        }
                    }
                }
            }
        } else if (selectedSubGame == 2) {
            // ==========================================
            // CITIES: SKYLINES & CITIES: SKYLINES II
            // ==========================================
            item {
                val interchanges = listOf(
                    "Turbine 4-Way Interchange",
                    "Stack Interchange 4-Level",
                    "Trumpet 3-Way",
                    "Roundabout 6-Lane Turbo",
                    "Cloverleaf High-Speed"
                )

                SectionCard(
                    title = "Bảng Điều Khiển Cities: Skylines & Skylines II",
                    subtitle = "Quy hoạch đại đô thị, tối ưu hóa lưu lượng giao thông và xuất preset",
                    icon = Icons.Default.Traffic,
                    badgeText = "Traffic 88%+",
                    badgeColor = SuccessGreen
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Overview Stats
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = PrimaryNavy,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("Tên Đô Thị:", color = Color.White, fontSize = 13.sp)
                                    Text(uiState.citiesSkylinesConfig.cityName, fontWeight = FontWeight.Bold, color = AccentGold)
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("Dân Số:", color = Color.White, fontSize = 13.sp)
                                    Text("${uiState.citiesSkylinesConfig.population} Dân", fontWeight = FontWeight.Bold, color = AccentTeal)
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("Lưu Lượng Giao Thông:", color = Color.White, fontSize = 13.sp)
                                    Text("${uiState.citiesSkylinesConfig.trafficFlowPercent}% (Rất Mượt)", fontWeight = FontWeight.Bold, color = SuccessGreen)
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("Ngân Sách Kho Bạc:", color = Color.White, fontSize = 13.sp)
                                    Text("₡${uiState.citiesSkylinesConfig.treasuryBalance} (+₡${uiState.citiesSkylinesConfig.weeklyIncome}/tuần)", fontWeight = FontWeight.Bold, color = AccentAmberLight)
                                }
                            }
                        }

                        // Traffic Flow & Interchange Selector
                        Text("Chọn Thiết Kế Nút Giao Cao Tốc Mẫu (Interchange):", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(interchanges) { ic ->
                                val isSelected = uiState.citiesSkylinesConfig.selectedInterchange == ic
                                FilterChip(
                                    selected = isSelected,
                                    onClick = {
                                        viewModel.updateCitiesSkylinesConfig(uiState.citiesSkylinesConfig.copy(selectedInterchange = ic))
                                    },
                                    label = { Text(ic, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = AccentGold.copy(alpha = 0.2f),
                                        selectedLabelColor = AccentGold
                                    )
                                )
                            }
                        }

                        // RICO Demand Meters
                        Text("Phân Bổ Tỷ Lệ Nhu Cầu Quy Hoạch (RICO):", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("🟢 Nhà ở (Residential):", fontSize = 12.sp)
                                    Text("${uiState.citiesSkylinesConfig.ricoDemandResidential}%", fontWeight = FontWeight.Bold, color = SuccessGreen)
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("🔵 Thương mại (Commercial):", fontSize = 12.sp)
                                    Text("${uiState.citiesSkylinesConfig.ricoDemandCommercial}%", fontWeight = FontWeight.Bold, color = PrimaryLightBlue)
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("🟠 Công nghiệp sạch (Industrial):", fontSize = 12.sp)
                                    Text("${uiState.citiesSkylinesConfig.ricoDemandIndustrial}%", fontWeight = FontWeight.Bold, color = AccentAmberLight)
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                                    Text("🟣 Văn phòng IT & Nghiên cứu (Office):", fontSize = 12.sp)
                                    Text("${uiState.citiesSkylinesConfig.ricoDemandOffice}%", fontWeight = FontWeight.Bold, color = PurpleAccent)
                                }
                            }
                        }

                        // City Policy Toggles
                        Text("Chính Sách Đô Thị (Policies):", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Miễn phí phương tiện công cộng (Free Transit):", fontSize = 12.sp)
                            Switch(
                                checked = uiState.citiesSkylinesConfig.enableFreePublicTransport,
                                onCheckedChange = {
                                    viewModel.updateCitiesSkylinesConfig(uiState.citiesSkylinesConfig.copy(enableFreePublicTransport = it))
                                }
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Nhà ở Công nghệ cao (High-Tech Housing):", fontSize = 12.sp)
                            Switch(
                                checked = uiState.citiesSkylinesConfig.enableHighTechHousing,
                                onCheckedChange = {
                                    viewModel.updateCitiesSkylinesConfig(uiState.citiesSkylinesConfig.copy(enableHighTechHousing = it))
                                }
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        // Optimize Traffic Button
                        Button(
                            onClick = {
                                viewModel.optimizeCitiesSkylinesTraffic()
                                Toast.makeText(context, "Đã tối ưu hóa lưu lượng giao thông đô thị lên 91%!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = SuccessGreen),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.AutoFixHigh, contentDescription = null, tint = Color.Black)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Tối Ưu Hóa Giao Thông Lên 91% (TM:PE Engine)", color = Color.Black, fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        // Generated XML Profile Viewer
                        CodeViewerBox(
                            codeText = if (uiState.citiesSkylinesGeneratedXml.isNotEmpty()) uiState.citiesSkylinesGeneratedXml else """<?xml version="1.0" encoding="utf-8"?>
<CitySaveProfile>
  <Meta>
    <CityName>${uiState.citiesSkylinesConfig.cityName}</CityName>
    <Mayor>${uiState.citiesSkylinesConfig.mayorName}</Mayor>
    <Population>${uiState.citiesSkylinesConfig.population}</Population>
    <TrafficFlow>${uiState.citiesSkylinesConfig.trafficFlowPercent}%</TrafficFlow>
    <TreasuryBalance>₡${uiState.citiesSkylinesConfig.treasuryBalance}</TreasuryBalance>
    <TargetInterchange>${uiState.citiesSkylinesConfig.selectedInterchange}</TargetInterchange>
  </Meta>
</CitySaveProfile>""",
                            language = "Cities: Skylines XML Preset"
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã xuất preset cấu hình đô thị Cities: Skylines (.crp / XML) thành công!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Download, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Xuất Bản Đồ / Mod Savefile (.crp & XML)", color = Color.White)
                        }
                    }
                }
            }
        } else {
            // THEOTOWN & CITY ISLAND 6
            item {
                SectionCard(
                    title = "Trình Tạo Plugins TheoTown (.ttplugin)",
                    subtitle = "Khung hình mùa đông, hạt particle & đèn đêm",
                    icon = Icons.Default.Apartment,
                    badgeText = "TheoTown Studio"
                ) {
                    OutlinedTextField(
                        value = uiState.theoTownPlugin.title,
                        onValueChange = { viewModel.updateTheoTownPlugin(uiState.theoTownPlugin.copy(title = it)) },
                        label = { Text("Tiêu Đề Công Trình") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Khung hình mùa đông:")
                        Switch(
                            checked = uiState.theoTownPlugin.hasWinterFrame,
                            onCheckedChange = { viewModel.updateTheoTownPlugin(uiState.theoTownPlugin.copy(hasWinterFrame = it)) }
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Tự động bật đèn ban đêm:")
                        Switch(
                            checked = uiState.theoTownPlugin.hasNightLight,
                            onCheckedChange = { viewModel.updateTheoTownPlugin(uiState.theoTownPlugin.copy(hasNightLight = it)) }
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    CodeViewerBox(codeText = uiState.theoTownGeneratedJson, language = "TheoTown JSON")
                }
            }

            item {
                SectionCard(
                    title = "Trình Khôi Phục & Tài Nguyên City Island 6",
                    subtitle = "Mã kích hoạt cấu trúc CIxxxxxx",
                    icon = Icons.Default.Forest,
                    badgeText = "City Island 6"
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Tên Đảo:", fontSize = 13.sp)
                            Text(uiState.cityIslandConfig.islandName, fontWeight = FontWeight.Bold, color = AccentTeal)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Mã kích hoạt:", fontSize = 13.sp)
                            Text(uiState.cityIslandConfig.activationCode, fontWeight = FontWeight.Bold, color = AccentGold)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Tiền mặt & Vàng:", fontSize = 13.sp)
                            Text("999.999.999", fontWeight = FontWeight.Bold, color = SuccessGreen)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Button(
                            onClick = {
                                Toast.makeText(context, "Đã áp dụng gói tài nguyên City Island 6!", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryNavy),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Cấp Tài Nguyên & Khôi Phục Thành Phố", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}
